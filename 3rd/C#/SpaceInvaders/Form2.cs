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

namespace SpaceInvaders
{
    public partial class form2 : Form
    {
        string path = Environment.CurrentDirectory + "/" + "history.txt";
        string path4 = Environment.CurrentDirectory + "/" + "tmp.txt";
        public form2()
        {
            InitializeComponent();

            FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

        }

        //Define difficulty 
        public static int dif;
        public static string name;


        private void EasyButton_Click(object sender, EventArgs e)
        {
            dif = 0;
            EasyButton.BackColor = Color.Red;
            NormalButton.BackColor = default(Color);
            HardButton.BackColor = default(Color);
            DarkSoulsButton.BackColor = default(Color);

        }

        private void NormalButton_Click(object sender, EventArgs e)
        {
            dif = 1;
            EasyButton.BackColor = default(Color);
            NormalButton.BackColor = Color.Red;
            HardButton.BackColor = default(Color);
            DarkSoulsButton.BackColor = default(Color);
        }

        private void HardButton_Click(object sender, EventArgs e)
        {
            dif = 2;
            EasyButton.BackColor = default(Color);
            NormalButton.BackColor = default(Color);
            HardButton.BackColor = Color.Red;
            DarkSoulsButton.BackColor = default(Color);
        }

        private void DarkSoulsButton_Click(object sender, EventArgs e)
        {
            dif = 3;
            EasyButton.BackColor = default(Color);
            NormalButton.BackColor = default(Color);
            HardButton.BackColor = default(Color);
            DarkSoulsButton.BackColor = Color.Red;
        }

        private void ContinueButton_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            if (PlayersNameTextBox.Text == "")
            {
                MessageBox.Show("Please insert your name");
            }
            else
            {
                File.AppendAllText(path4, PlayersNameTextBox.Text);
                switch (dif)
                {
                    case 0:
                        this.Hide();
                        form3.ShowDialog();
                        break;

                    case 1:
                        this.Hide();
                        form3.ShowDialog();
                        break;

                    case 2:
                        this.Hide();
                        form3.ShowDialog();
                        break;

                    case 3:
                        this.Hide();
                        form3.ShowDialog();
                        break;

                    default:
                        this.Hide();
                        form3.ShowDialog();
                        break;
                }
            }
        }

        private void MenuButton_Click(object sender, EventArgs e)
        {
            File.WriteAllText(path4, String.Empty);
            Form1 form1 = new Form1();
            this.Hide();
            form1.ShowDialog();
        }
    }
}
