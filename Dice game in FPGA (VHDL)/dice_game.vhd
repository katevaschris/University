library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity dice_game is
Port ( 
    clk,roll,new_game : in STD_LOGIC;
    dices : out UNSIGNED(5 DOWNTO 0);
    win,lose : out STD_LOGIC;
    finished : out STD_LOGIC_VECTOR(3 DOWNTO 0)
);
end dice_game;

architecture Structural of dice_game is

-- /Finite State Machine/ -- BEGIN
TYPE states IS (phase1,rolling,stopped,result,phase2,won,lost);
SIGNAL current_state, next_state : states;
-- /Finite State Machine/ -- END
SIGNAL counter1,counter2,dice_sum : UNSIGNED(3 DOWNTO 0);
SIGNAL dice1,dice2,res_counter : UNSIGNED(2 DOWNTO 0);
SIGNAL div_clk,roll_enable,sum_enable,first_time : STD_LOGIC;

begin

registers_circuit : process(clk,new_game)
begin
    if new_game = '1' then
        current_state <= phase1;    -- Phase1 is the initial state of the FSM when triggering an asychronous reset for the registers.
        first_time <= '1';          -- first_time is a signal describing whether we roll the dices for the first time or not.
        dice_sum <= "0000";         -- dice_sum is the register storing the sum whenever we do not have a result(win or lose).
    elsif clk'event and clk = '1' then
        current_state <= next_state;
        if sum_enable = '1' then        
            dice_sum <= ('0' & dice2) + ('0' & dice1);  -- We store the current sum in the register and
            first_time <= '0';                          -- make sure that we change the first_time signal as well.
        end if;
    end if;
end process;

combinational_circuit : process(current_state,roll,dice1,dice2,counter1,counter2,dice_sum,first_time)
begin
    roll_enable <= '0'; sum_enable <= '0';
    next_state <= current_state;

    case current_state is
        when phase1 =>
            if roll = '1' then next_state <= rolling; end if;       
        when rolling =>
            roll_enable <= '1';  
            if roll = '0' then
                next_state <= stopped;
            end if;
        when stopped =>
            roll_enable <= '1';
            if counter1 = 8 then next_state <= result; end if;      -- When counter1 expires (4 seconds) we proceed to the next state. 
        when result =>
            if counter2 = 8 then        -- When counter2 expires (4 seconds) we proceed to the next state according to the current sum.
                if first_time = '1' then
                    if ('0' & dice2) + ('0' & dice1) = 7 OR ('0' & dice2) + ('0' & dice1) = 11 then
                        next_state <= won;
                    elsif ('0' & dice2) + ('0' & dice1) = 2 OR ('0' & dice2) + ('0' & dice1) = 3 OR ('0' & dice2) + ('0' & dice1) = 12 then
                        next_state <= lost;
                    else
                        sum_enable <= '1';      -- This enable signal is an input to the dice_sum register, meaning that we want to store the current sum
                        next_state <= phase2;   -- to the register if only we do not have a result (win or lose).
                    end if;
                else
                    if ('0' & dice2) + ('0' & dice1) = 12 OR dice_sum = ('0' & dice2) + ('0' & dice1) then      -- For the second condition we compare the current sum
                         next_state <= won;                                                                     -- with the stored sum from the register dice_sum.
                    elsif ('0' & dice2) + ('0' & dice1) = 7 OR ('0' & dice2) + ('0' & dice1) = 11 then
                        next_state <= lost;
                    else
                        sum_enable <= '1';
                        next_state <= phase2;
                    end if;
                end if; 
            end if;
         when phase2 =>
            if roll = '1' then next_state <= rolling; end if;               
         when won =>
         when lost =>      
    end case;                
end process;

output_circuit : process(current_state,dice1,dice2)     -- The output of the machine depends not only from the current state but also from the input (internally)     
begin
    win <= '0'; lose <= '0';        -- Most of the states have zero output for the win and lose signals. 
    case current_state is
        when phase1   => dices <= "000000";
        when rolling  => dices <= dice2 & dice1;
        when stopped  => dices <= dice2 & dice1;
        when result   => dices <= dice2 & dice1;
        when phase2   => dices <= ("000" & dice2) + ("000" & dice1);  
        when won      => dices <= ("000" & dice2) + ("000" & dice1); win <= '1';
        when lost     => dices <= ("000" & dice2) + ("000" & dice1); lose <= '1';
    end case;
end process;

won_counter_register : process(div_clk,new_game)        -- Counter for the blinking output when we have a result (win or lose).
begin
    if new_game = '1' then
        res_counter <= "000";
    elsif div_clk'event and div_clk = '1' then
        if current_state = won OR current_state = lost then
            if res_counter < 4 then
                res_counter <= res_counter + 1;
            else
                res_counter <= "000";
            end if;
        else
            res_counter <= "000";
        end if;
    end if;
end process;
finished <= "1111" when res_counter = "011" OR res_counter = "010" else "0000";

counter1_register: process(div_clk,new_game)        -- Counter for the stopped state (when we turn off the roll switch)
begin
    if new_game = '1' then
       counter1 <= "0000";
    elsif div_clk'event and div_clk = '1' then
       if current_state = stopped then
           if counter1 < 8  then
               counter1 <= counter1 + 1;
           end if;
       else
           counter1 <= "0000";
       end if;
    end if;
end process;    
 
counter2_register: process(div_clk,new_game)        -- Counter for the result state (when the output of the controller transits from the dices' value to their sum)
begin
    if new_game = '1' then
        counter2 <= "0000";
    elsif div_clk'event and div_clk = '1' then
        if current_state = result then
            if counter2 < 8 then
                counter2 <= counter2 + 1;
            end if;
        else
            counter2 <= "0000";
        end if;
    end if;
end process;
 
dice_generator: entity work.dice_generator(Behavioral)      -- LFSR implementation for randomness of the dices
                port map(roll_enable,new_game,clk,dice1,dice2);

frequency_divider: entity work.freq_div(Behavioral)     -- Dividing the clock for the counters
                   port map(clk,div_clk);

end Structural;
