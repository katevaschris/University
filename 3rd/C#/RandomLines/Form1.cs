using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RandomLines
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        Pen p;
        Graphics g;
        Random r;

        private void Form1_Load(object sender, EventArgs e)
        {
            p = new Pen(Color.Blue);
            g = this.CreateGraphics();
            r = new Random();
        }


        private void Timer1_Tick(object sender, EventArgs e)
        {
            //Set a value to random angle
            an = r.Next(0, 360);
            //Generate the random angle
            cos = (float)Math.Cos(an);
            sin = (float)Math.Sin(an);
            g.DrawLine(p, x, y, x + cos* 100, y + sin * 100);
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            timer1.Enabled = true;
            //Mouse cordinates (global var)
            x = e.X;
            y = e.Y;
        }
        int x, y;
        float cos, sin, an;

    }
    
}
