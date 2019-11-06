using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace RandomNumbers
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            int num, x , y;
            Random r = new Random();
            if (textBox1.Text != "")
            {
                if (int.TryParse(textBox1.Text, out num))
                {
                    x = Convert.ToInt32(textBox1.Text);
                    y = r.Next(0, x);
                    var Ar = new List<int>();


                    richTextBox1.Text = "Random number : " + y.ToString() + "\n";
                    richTextBox1.Text += Environment.NewLine + "The list is : ";
                    for (int i = 0; i < y; i++)
                    {
                        Ar.Add(i);
                        richTextBox1.Text += Environment.NewLine + Ar[i].ToString();
                    }


                    //So a random cell (from what remains) is choosen, printed and poped out of the list
                    //so it will not be choosen again
                    richTextBox1.Text += Environment.NewLine + "Same list random ordered : ";
                    for (int i = 0; i < y; i++)
                    {
                        x = r.Next(0, Ar.Count);
                        richTextBox1.Text += Environment.NewLine + Ar[x].ToString();
                        Ar.RemoveAt(x);
                    }
                }
                else
                {
                    MessageBox.Show("Please give an Integer");
                }
            }
        }
    }
}
