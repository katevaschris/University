library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity dice_generator is
Port ( 
enable,reset,clk : in STD_LOGIC;
dice1,dice2 : out UNSIGNED(2 DOWNTO 0)
);
end dice_generator;

architecture Behavioral of dice_generator is

SIGNAL feedback,div_clk : STD_LOGIC;
SIGNAL LFSR : UNSIGNED(11 DOWNTO 0);
SIGNAL dice1_tmp,dice2_tmp : UNSIGNED(2 DOWNTO 0);

begin

feedback <= LFSR(0) XOR LFSR(3) XOR LFSR(5) XOR LFSR(11);      -- Tapping bits for the LFSR. 
dice1_tmp <= LFSR(10) & LFSR(4) & LFSR(1);
dice2_tmp <= LFSR(8) & LFSR(6) & LFSR(2);

LFSR_register: process(clk,reset)
begin
    if reset = '1' then
        LFSR <= (0 => '1', 1 => '1', others => '0');    -- Initial State of LFSR
    elsif clk'event and clk = '1' then        
        LFSR <= LFSR(10 DOWNTO 0) & feedback; -- When roll switch is turned off, the LFSR freezes
    end if;
end process; 

dices_output: process(div_clk,reset)
begin
    if reset = '1' then
        dice1 <= "001";        -- Initial State of LFSR
        dice2 <= "010";
    elsif div_clk'event and div_clk = '1' then
        if enable = '1' then
            if dice1_tmp = "000" then
                dice1 <= "001";
            elsif dice1_tmp = "111" then
                dice1 <= "110";
            else
                dice1 <= dice1_tmp;
            end if; 
            
            if dice2_tmp = "000" then
                dice2 <= "001";
            elsif dice2_tmp = "111" then
                dice2 <= "110";
            else
                dice2 <= dice2_tmp;
            end if;     
        end if;       
    end if;
end process; 
         
frequency_divider : entity work.freq_div(Behavioral)
                    port map(clk,div_clk);
         
end Behavioral;