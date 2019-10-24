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
