using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows.Forms;
using WMPLib;

namespace SpaceInvaders
{
    public partial class Form1 : Form
    {


        public static WindowsMediaPlayer player1 = new WindowsMediaPlayer();

        public Form1()
        {
            InitializeComponent();
            player1.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "StrangerThingsMainThemeRemix.mp3";
            player1.controls.play();


            FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
        }

        //Global var that defines txts
        string path = Environment.CurrentDirectory + "/" + "history.txt";
        string path1 = Environment.CurrentDirectory + "/" + "score.txt";
        string path2 = Environment.CurrentDirectory + "/" + "dif.txt";
        string path3 = Environment.CurrentDirectory + "/" + "name.txt";
        string path4 = Environment.CurrentDirectory + "/" + "tmp.txt";

        private void ScoreButton_Click(object sender, EventArgs e)
        {
            if(!File.Exists(path1))
            {
                File.CreateText(path1);
            }
            if(!File.Exists(path2))
            {
                File.CreateText(path2);
            }
            if(!File.Exists(path3))
            {
                File.CreateText(path3);
            }
            if (!File.Exists(path4))
            {
                File.CreateText(path4);
            }


            if (!File.Exists(path))
            {
                File.CreateText(path);
            }
            else
            {
                using (StreamReader sr = new StreamReader(path))
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
                        if (line == null)
                        {
                            break;
                        }
                    }
                    //Print all the history to RichTextBox
                    richTextBox1.Text = text;

                }
            }

        }

        private void ClearScoreButton_Click(object sender, EventArgs e)
        {
            if (File.Exists(path))
            {
                //Delete the score.txt and print the message
                //File.Delete(path);

                //Emptying the txt file instead of deleting it
                //There is a bug if delete txt show score and again choose clear
                DialogResult dialogResult = MessageBox.Show("Clear Scores?", "Warning", MessageBoxButtons.YesNo);
                if (dialogResult == DialogResult.Yes)
                {
                    File.WriteAllText(path, String.Empty);
                    File.WriteAllText(path1, String.Empty);
                    File.WriteAllText(path2, String.Empty);
                    File.WriteAllText(path3, String.Empty);
                    richTextBox1.Text = "Scores Cleared";
                }

            }
        }

        private void ExitButton_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void PlayButton_Click(object sender, EventArgs e)
        {
            if (!File.Exists(path))
            {
                File.CreateText(path);
            }

            form2 form2 = new form2();
            //player1.controls.stop();
            this.Hide();
            
            form2.ShowDialog();
        }



        private void Top10Button_Click(object sender, EventArgs e)
        {
            string[] scores = File.ReadAllLines(path1);
            int[] sorted = Array.ConvertAll(scores, s => int.Parse(s));
            string[] names = File.ReadAllLines(path3);
            string[] dif = File.ReadAllLines(path2);


            int temp;
            for (int i = 0; i < sorted.Length - 1; i++)
            {
                for (int j = i + 1; j < sorted.Length; j++)
                {
                    if (sorted[i] < sorted[j])
                    {

                        temp = sorted[i];
                        sorted[i] = sorted[j];
                        sorted[j] = temp;


                        names[i] = names[i] + names[j];
                        names[j] = names[i].Substring(0, names[i].Length - names[j].Length);
                        names[i] = names[i].Substring(names[j].Length);

                        dif[i] = dif[i] + dif[j];
                        dif[j] = dif[i].Substring(0, dif[i].Length - dif[j].Length);
                        dif[i] = dif[i].Substring(dif[j].Length);

                    }
                }
            }


            for (int i = 0; i < sorted.Length; ++i)
            {
                richTextBox1.AppendText(Environment.NewLine + "Name: " + names[i] + " Mode : " + dif[i] + " Scored : " + sorted[i].ToString());
            }

        }
    }
}
