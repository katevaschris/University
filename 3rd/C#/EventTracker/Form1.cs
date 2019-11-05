using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventTracker
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }




        //~~~~~~~~~~~~~~~~~~~~Button's Events~~~~~~~~~~~~~~~~~~~~//

        private void Button1_MouseClick(object sender, MouseEventArgs e)
        {
            MessageBox.Show("You just pressed the button... THE BUTTON!");
            MakeSomeHistory("Mouse clicked the Button on : ");
        }

        private void Button1_MouseDown(object sender, MouseEventArgs e)
        {
            BackColor = Color.Pink;
            label1.Text = ("You are holding down the button... THE BUTTON!");
        }

        private void Button1_MouseUp(object sender, MouseEventArgs e)
        {
            label1.Text = "I guess a Label";
        }

        private void Button1_MouseEnter(object sender, EventArgs e)
        {
            this.BackColor = Color.DarkCyan;
            MakeSomeHistory("Mouse entered the Button on : ");
        }

        private void Button1_MouseLeave(object sender, EventArgs e)
        {
            this.BackColor = default(Color);
            MakeSomeHistory("Mouse left the Button on : ");
        }









        //~~~~~~~~~~~~~~~~~~~~Label's Events~~~~~~~~~~~~~~~~~~~~//
        private void Label1_MouseEnter(object sender, EventArgs e)
        {
            MakeSomeHistory("Mouse entered the Label on : ");
        }

        private void Label1_TextChanged(object sender, EventArgs e)
        {
            MakeSomeHistory("Label's text changed on : ");
        }

        private void Label1_MouseLeave(object sender, EventArgs e)
        {
            MakeSomeHistory("Mouse left the Label on : ");
        }

        private void Label1_Click(object sender, EventArgs e)
        {
            label1.Text = "You are holding me down...";
            MakeSomeHistory("Mouse clicked the Label on : ");
        }









        //~~~~~~~~~~~~~~~~~~~~TextBox's Events~~~~~~~~~~~~~~~~~~~~//
        private void TextBox1_TextChanged(object sender, EventArgs e)
        {
            //One key pressed means a new log into the history
            MakeSomeHistory("TextBox's text changed on : ");
        }

        private void TextBox1_MouseClick(object sender, MouseEventArgs e)
        {
            label1.Text = textBox1.Text;
            MakeSomeHistory("Mouse clicked the TextBox on : ");
        }

        private void TextBox1_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            label1.Text = "The cake is a lie! The cake is a lie! The cake is a lie!";
            MakeSomeHistory("Mouse double-clicked the TextBox on : ");
        }

        private void TextBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            //When key is pressed, TextBox clicked and hit the enter button
            MakeSomeHistory("User pressed the key : " +label1.Text + " on : ");
        }










        //~~~~~~~~~~~~~~~~~~~~Panel's Events~~~~~~~~~~~~~~~~~~~~//


        private void Panel1_MouseClick(object sender, MouseEventArgs e)
        {
            this.BackColor = Color.DarkBlue;
            MakeSomeHistory("Mouse clicked the panel on : ");
        }

        private void Panel1_MouseEnter(object sender, EventArgs e)
        {
            this.BackColor = Color.DarkRed;
            MakeSomeHistory("Mouse entered the panel on : ");
        }

        private void Panel1_MouseLeave(object sender, EventArgs e)
        {
            this.BackColor = default;
            MakeSomeHistory("Mouse left the panel on : ");
        }

        private void Panel1_DoubleClick(object sender, EventArgs e)
        {
            this.BackColor = Color.Purple;
            MakeSomeHistory("Mouse  double-clicked the panel on : ");
        }









        //~~~~~~~~~~~~~~~~~~~~RadioButton's Events~~~~~~~~~~~~~~~~~~~~//
        private void RadioButton1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Helf Life 3 Confirmed");
            MakeSomeHistory("Mouse clicked on the RadioButton on : ");
        }

        private void RadioButton1_MouseUp(object sender, MouseEventArgs e)
        {
            textBox1.Text = "Portal 3 Confirmed";
            MakeSomeHistory("Mouse unclicked on the RadioButton on : ");
        }

        private void RadioButton1_MouseEnter(object sender, EventArgs e)
        {
            MakeSomeHistory("Mouse entered  the RadioButton on : ");
        }

        private void RadioButton1_MouseLeave(object sender, EventArgs e)
        {
            MakeSomeHistory("Mouse left  the RadioButton on : ");
        }









        //~~~~~~~~~~~~~~~~~~~~ComboBox's Events~~~~~~~~~~~~~~~~~~~~//
        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            MakeSomeHistory("User choosed : " + comboBox1.Text + " on: ");
        }

        private void ComboBox1_DropDown(object sender, EventArgs e)
        {
            MakeSomeHistory("User opened the ComboBox (Drop Down) on : ");
        }

        private void ComboBox1_DropDownClosed(object sender, EventArgs e)
        {
            MakeSomeHistory("User closed the ComboBox (Drop Down) on : ");
        }

        private void ComboBox1_MouseClick(object sender, MouseEventArgs e)
        {
            MakeSomeHistory("Mouse clicked on the ComboBox (Drop Down) on : ");
        }









        










        /*
         Event's History
        */
        //path is a global var that contains the path for the txt file named history.txt
        string path = Environment.CurrentDirectory + "/" + "history.txt";
        private void Button2_MouseClick(object sender, MouseEventArgs e)
        {
            string path = Environment.CurrentDirectory + "/" + "history.txt";
            if(!File.Exists(path))
            {
                File.CreateText(path);
                richTextBox1.Text = "Text File history.txt created";
            }
            else
            {
                using(StreamReader sr = new StreamReader(path))
                {
                    string text = "";
                    string line;
                    //Read lines from history.txt up until you find null
                    while (true)
                    {
                        line = sr.ReadLine();
                        //Old lines = Old Lines + new line + new empty line
                        text = text + line + "\n";
                        //Break the loop if you find null line
                        if(line == null)
                        {
                            break;
                        }
                    }
                    //Print all the history to RichTextBox
                    richTextBox1.Text = text;

                }
            }
        }

        private void  MakeSomeHistory(string x)
        {
            //Create new line on the txt file and 
            File.AppendAllText(path, x + DateTime.Now.ToString() + "\n");
        }

        private void Button3_MouseClick(object sender, MouseEventArgs e)
        {
            if(File.Exists(path))
            {
                //Delete the history.txt and print the message
                //File.Delete(path);

                //Emptying rthe txt file instead of deleting it
                //There is a bug if delete txt show history and again choose clear
                File.WriteAllText(path, String.Empty);
                richTextBox1.Text = "History Deleted";
            }
        }

    }
}
