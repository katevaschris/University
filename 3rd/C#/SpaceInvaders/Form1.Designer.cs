namespace SpaceInvaders
{
    partial class Form1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.LogoLabel = new System.Windows.Forms.Label();
            this.PlayButton = new System.Windows.Forms.Button();
            this.ExitButton = new System.Windows.Forms.Button();
            this.ScoreButton = new System.Windows.Forms.Button();
            this.ClearScoreButton = new System.Windows.Forms.Button();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.axWindowsMediaPlayer1 = new AxWMPLib.AxWindowsMediaPlayer();
            this.Top10Button = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).BeginInit();
            this.SuspendLayout();
            // 
            // LogoLabel
            // 
            this.LogoLabel.AutoSize = true;
            this.LogoLabel.BackColor = System.Drawing.Color.Transparent;
            this.LogoLabel.Font = new System.Drawing.Font("MV Boli", 27.75F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LogoLabel.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.LogoLabel.Location = new System.Drawing.Point(36, 43);
            this.LogoLabel.Name = "LogoLabel";
            this.LogoLabel.Size = new System.Drawing.Size(286, 49);
            this.LogoLabel.TabIndex = 0;
            this.LogoLabel.Text = "Space Invaders";
            // 
            // PlayButton
            // 
            this.PlayButton.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.PlayButton.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.PlayButton.ForeColor = System.Drawing.SystemColors.WindowText;
            this.PlayButton.Location = new System.Drawing.Point(79, 192);
            this.PlayButton.Name = "PlayButton";
            this.PlayButton.Size = new System.Drawing.Size(121, 41);
            this.PlayButton.TabIndex = 1;
            this.PlayButton.Text = "Play";
            this.PlayButton.UseVisualStyleBackColor = false;
            this.PlayButton.Click += new System.EventHandler(this.PlayButton_Click);
            // 
            // ExitButton
            // 
            this.ExitButton.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.ExitButton.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ExitButton.ForeColor = System.Drawing.SystemColors.WindowText;
            this.ExitButton.Location = new System.Drawing.Point(79, 344);
            this.ExitButton.Name = "ExitButton";
            this.ExitButton.Size = new System.Drawing.Size(121, 41);
            this.ExitButton.TabIndex = 2;
            this.ExitButton.Text = "Exit";
            this.ExitButton.UseVisualStyleBackColor = false;
            this.ExitButton.Click += new System.EventHandler(this.ExitButton_Click);
            // 
            // ScoreButton
            // 
            this.ScoreButton.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.ScoreButton.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ScoreButton.ForeColor = System.Drawing.SystemColors.WindowText;
            this.ScoreButton.Location = new System.Drawing.Point(426, 101);
            this.ScoreButton.Name = "ScoreButton";
            this.ScoreButton.Size = new System.Drawing.Size(121, 41);
            this.ScoreButton.TabIndex = 3;
            this.ScoreButton.Text = "Score";
            this.ScoreButton.UseVisualStyleBackColor = false;
            this.ScoreButton.Click += new System.EventHandler(this.ScoreButton_Click);
            // 
            // ClearScoreButton
            // 
            this.ClearScoreButton.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.ClearScoreButton.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ClearScoreButton.ForeColor = System.Drawing.SystemColors.WindowText;
            this.ClearScoreButton.Location = new System.Drawing.Point(694, 101);
            this.ClearScoreButton.Name = "ClearScoreButton";
            this.ClearScoreButton.Size = new System.Drawing.Size(121, 41);
            this.ClearScoreButton.TabIndex = 4;
            this.ClearScoreButton.Text = "Clear";
            this.ClearScoreButton.UseVisualStyleBackColor = false;
            this.ClearScoreButton.Click += new System.EventHandler(this.ClearScoreButton_Click);
            // 
            // richTextBox1
            // 
            this.richTextBox1.BackColor = System.Drawing.SystemColors.WindowText;
            this.richTextBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.richTextBox1.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.richTextBox1.Location = new System.Drawing.Point(276, 171);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(968, 432);
            this.richTextBox1.TabIndex = 5;
            this.richTextBox1.Text = "";
            // 
            // axWindowsMediaPlayer1
            // 
            this.axWindowsMediaPlayer1.Enabled = true;
            this.axWindowsMediaPlayer1.Location = new System.Drawing.Point(12, 610);
            this.axWindowsMediaPlayer1.Name = "axWindowsMediaPlayer1";
            this.axWindowsMediaPlayer1.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axWindowsMediaPlayer1.OcxState")));
            this.axWindowsMediaPlayer1.Size = new System.Drawing.Size(38, 33);
            this.axWindowsMediaPlayer1.TabIndex = 6;
            this.axWindowsMediaPlayer1.Visible = false;
            // 
            // Top10Button
            // 
            this.Top10Button.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.Top10Button.Font = new System.Drawing.Font("MingLiU_HKSCS-ExtB", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Top10Button.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Top10Button.Location = new System.Drawing.Point(384, 637);
            this.Top10Button.Name = "Top10Button";
            this.Top10Button.Size = new System.Drawing.Size(121, 41);
            this.Top10Button.TabIndex = 7;
            this.Top10Button.Text = "Top10";
            this.Top10Button.UseVisualStyleBackColor = false;
            this.Top10Button.Click += new System.EventHandler(this.Top10Button_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1284, 714);
            this.Controls.Add(this.Top10Button);
            this.Controls.Add(this.axWindowsMediaPlayer1);
            this.Controls.Add(this.richTextBox1);
            this.Controls.Add(this.ClearScoreButton);
            this.Controls.Add(this.ScoreButton);
            this.Controls.Add(this.ExitButton);
            this.Controls.Add(this.PlayButton);
            this.Controls.Add(this.LogoLabel);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.Text = "Space Invaders";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label LogoLabel;
        private System.Windows.Forms.Button PlayButton;
        private System.Windows.Forms.Button ExitButton;
        private System.Windows.Forms.Button ScoreButton;
        private System.Windows.Forms.Button ClearScoreButton;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private AxWMPLib.AxWindowsMediaPlayer axWindowsMediaPlayer1;
        private System.Windows.Forms.Button Top10Button;
    }
}

