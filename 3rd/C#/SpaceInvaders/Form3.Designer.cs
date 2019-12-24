namespace SpaceInvaders
{
    partial class Form3
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form3));
            this.ScoreLabel = new System.Windows.Forms.Label();
            this.ScoreLabelNum = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.timer2 = new System.Windows.Forms.Timer(this.components);
            this.TimeLabel = new System.Windows.Forms.Label();
            this.TimeLeftLabel = new System.Windows.Forms.Label();
            this.Guns = new System.Windows.Forms.ImageList(this.components);
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.MenuButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.SuspendLayout();
            // 
            // ScoreLabel
            // 
            this.ScoreLabel.AutoSize = true;
            this.ScoreLabel.BackColor = System.Drawing.Color.Transparent;
            this.ScoreLabel.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ScoreLabel.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.ScoreLabel.Location = new System.Drawing.Point(12, 9);
            this.ScoreLabel.Name = "ScoreLabel";
            this.ScoreLabel.Size = new System.Drawing.Size(117, 27);
            this.ScoreLabel.TabIndex = 0;
            this.ScoreLabel.Text = "Score: ";
            // 
            // ScoreLabelNum
            // 
            this.ScoreLabelNum.AutoSize = true;
            this.ScoreLabelNum.BackColor = System.Drawing.Color.Transparent;
            this.ScoreLabelNum.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ScoreLabelNum.ForeColor = System.Drawing.Color.Lime;
            this.ScoreLabelNum.Location = new System.Drawing.Point(118, 9);
            this.ScoreLabelNum.Name = "ScoreLabelNum";
            this.ScoreLabelNum.Size = new System.Drawing.Size(30, 31);
            this.ScoreLabelNum.TabIndex = 1;
            this.ScoreLabelNum.Text = "0";
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox1.Location = new System.Drawing.Point(734, 204);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(100, 100);
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.PictureBox1_Click);
            this.pictureBox1.MouseDown += new System.Windows.Forms.MouseEventHandler(this.PictureBox1_MouseDown);
            this.pictureBox1.MouseUp += new System.Windows.Forms.MouseEventHandler(this.PictureBox1_MouseUp);
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.Timer1_Tick);
            // 
            // timer2
            // 
            this.timer2.Enabled = true;
            this.timer2.Interval = 2100;
            this.timer2.Tick += new System.EventHandler(this.Timer2_Tick);
            // 
            // TimeLabel
            // 
            this.TimeLabel.AutoSize = true;
            this.TimeLabel.BackColor = System.Drawing.Color.Transparent;
            this.TimeLabel.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TimeLabel.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.TimeLabel.Location = new System.Drawing.Point(547, 9);
            this.TimeLabel.Name = "TimeLabel";
            this.TimeLabel.Size = new System.Drawing.Size(162, 27);
            this.TimeLabel.TabIndex = 8;
            this.TimeLabel.Text = "Time Left:";
            // 
            // TimeLeftLabel
            // 
            this.TimeLeftLabel.AutoSize = true;
            this.TimeLeftLabel.BackColor = System.Drawing.Color.Transparent;
            this.TimeLeftLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TimeLeftLabel.ForeColor = System.Drawing.Color.Lime;
            this.TimeLeftLabel.Location = new System.Drawing.Point(699, 9);
            this.TimeLeftLabel.Name = "TimeLeftLabel";
            this.TimeLeftLabel.Size = new System.Drawing.Size(30, 31);
            this.TimeLeftLabel.TabIndex = 9;
            this.TimeLeftLabel.Text = "0";
            // 
            // Guns
            // 
            this.Guns.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("Guns.ImageStream")));
            this.Guns.TransparentColor = System.Drawing.Color.Transparent;
            this.Guns.Images.SetKeyName(0, "crowbar.png");
            this.Guns.Images.SetKeyName(1, "crowbar2.png");
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox2.Location = new System.Drawing.Point(72, 61);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(637, 358);
            this.pictureBox2.TabIndex = 10;
            this.pictureBox2.TabStop = false;
            this.pictureBox2.Click += new System.EventHandler(this.PictureBox2_Click);
            this.pictureBox2.MouseDown += new System.Windows.Forms.MouseEventHandler(this.PictureBox2_MouseDown);
            this.pictureBox2.MouseUp += new System.Windows.Forms.MouseEventHandler(this.PictureBox2_MouseUp);
            // 
            // MenuButton
            // 
            this.MenuButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.MenuButton.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.MenuButton.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MenuButton.ForeColor = System.Drawing.SystemColors.WindowText;
            this.MenuButton.Location = new System.Drawing.Point(891, 9);
            this.MenuButton.Name = "MenuButton";
            this.MenuButton.Size = new System.Drawing.Size(121, 41);
            this.MenuButton.TabIndex = 11;
            this.MenuButton.Text = "Menu";
            this.MenuButton.UseVisualStyleBackColor = false;
            this.MenuButton.Click += new System.EventHandler(this.MenuButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 72F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.Highlight;
            this.label1.Location = new System.Drawing.Point(196, 204);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(565, 108);
            this.label1.TabIndex = 12;
            this.label1.Text = "3 Confirmed";
            this.label1.Visible = false;
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1024, 571);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.MenuButton);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.TimeLeftLabel);
            this.Controls.Add(this.TimeLabel);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.ScoreLabelNum);
            this.Controls.Add(this.ScoreLabel);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.KeyPreview = true;
            this.Name = "Form3";
            this.Text = "Space Invaders";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form3_FormClosed);
            this.Click += new System.EventHandler(this.Form3_Click);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Form3_MouseDown);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Form3_MouseUp);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label ScoreLabel;
        private System.Windows.Forms.Label ScoreLabelNum;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Timer timer2;
        private System.Windows.Forms.Label TimeLabel;
        private System.Windows.Forms.Label TimeLeftLabel;
        private System.Windows.Forms.ImageList Guns;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Button MenuButton;
        private System.Windows.Forms.Label label1;
    }
}