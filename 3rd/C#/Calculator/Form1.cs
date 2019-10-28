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

            double num;

            if (textBox1.Text != "")
            {
                if (double.TryParse(textBox1.Text, out num))
                {
                    x = Convert.ToDouble(textBox1.Text);
                }
                else if (textBox1.Text == "e")
                {
                    x = 2.71828;
                }
                else if (textBox1.Text == "pi" || textBox1.Text == "π")
                {
                    x = 3.14159;
                }
                else
                {
                    MessageBox.Show("Watch out Mate!");
                    //Application.Exit();
                }
            }
            if(textBox2.Text != "")
            {
                if (double.TryParse(textBox2.Text, out num))
                {
                    y = Convert.ToDouble(textBox2.Text);
                }
                else if (textBox2.Text == "e")
                {
                    y = 2.71828;
                }
                else if (textBox2.Text == "pi" || textBox2.Text == "π")
                {
                    y = 3.14159;
                }
                else
                {
                    MessageBox.Show("Watch out Mate!");
                    //Application.Exit();
                }
            }


            string symbol = this.comboBox1.GetItemText(this.comboBox1.SelectedItem);
            if(symbol == "+")
            {
                result_label.Text = (x + y).ToString();
            }
            else if(symbol == "-")
            {
                result_label.Text = (x - y).ToString();
            }
            else if (symbol == "*")
            {
                result_label.Text = (x * y).ToString();
            }
            else if (symbol == "/")
            {
                //You can actually divide with zero!
                //Gets +infinty in case +/0
                //Gets -infinty in case -/0
                result_label.Text = (x / y).ToString();
                if(x == 0)
                {
                    if(y == 0)
                    {
                        result_label.Text = "To infinity and beyond!!";
                    }
                }
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
                if (y < 0)
                {
                    result_label.Text = "Only positive numbers!";
                }
                else
                {
                    result_label.Text = (Math.Sqrt(y)).ToString();
                }
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
