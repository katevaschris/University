/*
Author: Katevas Chris

github: https://github.com/katevaschris
	
Planet: Earth 
Date: 	
	
Version 1.0
Function:

Read more on: https://github.com/katevaschris/

Copyright (C)
Protected by GNU GPLv3

~ 
	
	Greetings Mate!
	¯\_(ツ)_/¯ 
	
	I don't mind what you use this code for! it wasn't made for professional use.
	Instead, it was made for educational purposes and for fun.
	Please hack this, change it and use it in any way you see fit.
	Please, be acknowledged that I take no responsibility for anything bad that 
	happens, to you as a result of your actions. However this code is protected by GNU GPLv3,
	this means you must attribute me if you use it. Have fun and...
	Cheers :D
	
~

 */
using System;
using System.Windows.Forms;


namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Calculate_Click(object sender, EventArgs e)
        {
            double x = 0;
            double y = 0;
            if(textBox1.Text != "")
            {
                x = Convert.ToDouble(textBox1.Text);
            }
            if(textBox2.Text != "")
            {
                y = Convert.ToDouble(textBox2.Text);
            }
            
            string symbol = this.comboBox1.GetItemText(this.comboBox1.SelectedItem);
            if(symbol == "+")
            {
                result_label.Text = (Convert.ToDouble(textBox1.Text) + Convert.ToDouble(textBox2.Text)).ToString();
            }
            else if(symbol == "-")
            {
                result_label.Text = (Convert.ToDouble(textBox1.Text) - Convert.ToDouble(textBox2.Text)).ToString();
            }
            else if (symbol == "*")
            {
                result_label.Text = (Convert.ToDouble(textBox1.Text) * Convert.ToDouble(textBox2.Text)).ToString();
            }
            else if (symbol == "/")
            {
                //You can actually divide with zero!
                result_label.Text = (Convert.ToDouble(textBox1.Text) / Convert.ToDouble(textBox2.Text)).ToString();
            }
            else if(symbol == "^")
            {
                result_label.Text = (Math.Pow(x, y)).ToString();
            }
            else if (symbol == "Round")
            {
                result_label.Text = (Math.Round(y)).ToString();
            }
            else if (symbol == "Abs")
            {
                result_label.Text = (Math.Abs(y)).ToString();
            }
            else// if (symbol == "√")
            {
                result_label.Text = (Math.Sqrt(y)).ToString();
            }

        }

        private void Label1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void ComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }
    }
}
