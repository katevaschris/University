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
    public partial class Form3 : Form
    {
        private WMPLib.WindowsMediaPlayer player2 = new WMPLib.WindowsMediaPlayer();
        private WMPLib.WindowsMediaPlayer effects = new WMPLib.WindowsMediaPlayer();
        Random r = new Random();
        public  int score = 0;
        private int timeleft = 20;



        string path = Environment.CurrentDirectory + "/" + "history.txt";
        string path1 = Environment.CurrentDirectory + "/" + "score.txt";
        string path2 = Environment.CurrentDirectory + "/" + "dif.txt";
        string path3 = Environment.CurrentDirectory + "/" + "name.txt";
        string path4 = Environment.CurrentDirectory + "/" + "tmp.txt";

        public string name;
        public int dif;


        public Form3()
        {
            InitializeComponent();

            //Stop the music from the previous form
            Form1.player1.controls.stop();
            FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            Left = Top = 0;
            Width = Screen.PrimaryScreen.WorkingArea.Width;
            Height = Screen.PrimaryScreen.WorkingArea.Height;
            //Custom cursor
            this.Cursor = Crowbar((Bitmap)Guns.Images[0], new Size(256, 256));

            dif = form2.dif;

            



            switch (dif)
            {
                case 0:
                    //Start playing music
                    player2.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "DeathStrandingMainTheme.mp3";
                    player2.controls.play();
                    BackgroundImage = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "BackGround" + "/" + "saturn.jpg");
                    pictureBox1.Image = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "Enemies" + "/" + "space_inv1.png");
                    timer1.Interval = 1700;
                    pictureBox2.Visible = false;
                    break;

                case 1:
                    //Start playing music
                    player2.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "StrangerThingsMainThemeRemix.mp3";
                    player2.controls.play();
                    BackgroundImage = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "BackGround" + "/" + "Lost.jpg");
                    pictureBox1.Image = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "Enemies" + "/" + "space_inv2.png");
                    timer1.Interval = 1000;
                    pictureBox2.Visible = false;
                    break;

                case 2:
                    //Start playing music
                    player2.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "Outbreak.mp3";
                    player2.controls.play();
                    BackgroundImage = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "BackGround" + "/" + "blackhole.jpg");
                    pictureBox1.Image = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "Enemies" + "/" + "space_inv3.png");
                    timer1.Interval = 900;
                    pictureBox2.Visible = false;
                    break;

                case 3:
                    //Start playing music
                    player2.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "PortalOpera.mp3";
                    player2.controls.play();
                    BackgroundImage = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "BackGround" + "/" + "thend.jpg");
                    pictureBox2.Image = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "Enemies" + "/" + "gman.png");
                    timer1.Interval = 500;
                    pictureBox1.Visible = false;
                    break;

                default:
                    //Start playing music
                    player2.URL = Environment.CurrentDirectory + "/" + "Music" + "/" + "DeathStrandingMainTheme.mp3";
                    player2.controls.play();
                    BackgroundImage = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "BackGround" + "/" + "saturn.jpg");
                    pictureBox1.Image = Image.FromFile(Environment.CurrentDirectory + "/" + "Images" + "/" + "Enemies" + "/" + "space_inv1.png");
                    timer1.Interval = 2000;
                    pictureBox2.Visible = false;
                    break;
            }
        }

        private void Timer1_Tick(object sender, EventArgs e)
        {
            int x = r.Next(0, Width);
            int y = r.Next(0, Height);
            pictureBox1.Top = y;
            pictureBox1.Left = x;
            pictureBox2.Top = y;
            pictureBox2.Left = x;
        }

        private void Timer2_Tick(object sender, EventArgs e)
        {
            if (timeleft > 0)
            {
                timeleft = timeleft - 1;
                TimeLeftLabel.Text = timeleft.ToString();
            }
            else
            {
                if (File.Exists(path) && File.Exists(path1) && File.Exists(path2) && File.Exists(path3) )
                {
                    File.AppendAllText(path1, score.ToString() + "\n");

                    string[] tmp = File.ReadAllLines(path4);
                    //string.Join("", tmp);
                    name = String.Concat(tmp);
                    //name = tmp;
                    File.AppendAllText(path3, name + "\n");
                    switch (dif)
                    {
                        case 0:
                            File.AppendAllText(path, "Name : " + name  + " | Date : " + DateTime.Now.ToString() + " | Mode : " + "Easy" + " | Scored : " + score + "\n");
                            File.AppendAllText(path2, "Easy" + "\n");
                            break;

                        case 1:
                            File.AppendAllText(path, "Name : " + name + " | Date : " + DateTime.Now.ToString() + " | Mode : " + "Normal" + " | Scored : " + score + "\n");
                            File.AppendAllText(path2, "Normal" + "\n");
                            break;

                        case 2:
                            File.AppendAllText(path, "Name : " + name + " | Date : " + DateTime.Now.ToString() + " | Mode : " + "Hard" + " | Scored : " + score + "\n");
                            File.AppendAllText(path2, "Hard" + "\n");
                            break;

                        case 3:
                            File.AppendAllText(path, "Name : " + name + " | Date : " + DateTime.Now.ToString() + " | Mode : " + "Dark Souls" + " | Scored : " + score + "\n");
                            File.AppendAllText(path2, "Dark Souls" + "\n");
                            break;

                        default:
                            File.AppendAllText(path, "Name : " + name + " | Date : " + DateTime.Now.ToString() + " | Mode : " + "Easy" + " | Scored : " + score + "\n");
                            File.AppendAllText(path2, "Easy" + "\n");
                            break;

                    }
                    
                }

                File.WriteAllText(path4, String.Empty);
                pictureBox1.Visible = false;
                pictureBox2.Visible = false;
                timer1.Stop();
                timer2.Stop();
                MessageBox.Show("Thanks for playing");
                label1.Visible = true;

            }
        }

        private void PictureBox1_Click(object sender, EventArgs e)
        {
            score++;
            ScoreLabelNum.Text = score.ToString();
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));
            effects.URL = Environment.CurrentDirectory + "/" + "Sounds" + "/" + "Guns" + "/" + "CrowbarSound.mp3";
        }

        private void PictureBox2_Click(object sender, EventArgs e)
        {
            score++;
            ScoreLabelNum.Text = score.ToString();
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));
            effects.URL = Environment.CurrentDirectory + "/" + "Sounds" + "/" + "Guns" + "/" + "CrowbarSound.mp3";
        }

        private void MenuButton_Click(object sender, EventArgs e)
        {
            effects.controls.stop();
            player2.controls.stop();
            Form1 form1 = new Form1();
            this.Hide();
            form1.ShowDialog();
        }

        //Cursor's extra movement
        private void PictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[0], new Size(256, 256));
        }
        
        private void PictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));
        }


        private void PictureBox2_MouseUp(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[0], new Size(256, 256));
        }

        private void PictureBox2_MouseDown(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));
        }

        private void Form3_Click(object sender, EventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));

        }

        private void Form3_MouseUp(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[0], new Size(256, 256));

        }

        private void Form3_MouseDown(object sender, MouseEventArgs e)
        {
            this.Cursor = Crowbar((Bitmap)Guns.Images[1], new Size(256, 256));
        }

        //Cursor's Bitmap
        public static Cursor Crowbar(Bitmap bit, Size size)
        {
            bit = new Bitmap(bit, size);
            return new Cursor(bit.GetHicon());
        }

        private void Form3_FormClosed(object sender, FormClosedEventArgs e)
        {
            File.WriteAllText(path4, String.Empty);
            effects.controls.stop();
            player2.controls.stop();
            Form1 form1 = new Form1();
            this.Hide();
            form1.ShowDialog();
        }
    }
}
