using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WMPLib;

namespace Address_Book
{
    public partial class Form1 : Form
    {
        String connectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=Database1.mdb";
        OleDbConnection connection;
        WindowsMediaPlayer player1 = new WindowsMediaPlayer();
        public string photo = null;
        public string music = null;
        public bool flag = false;

        //______________________________________________________
        public Form1()
        {
            InitializeComponent();
        }

        //______________________________________________________
        private void Form1_Load(object sender, EventArgs e)
        {
            connection = new OleDbConnection(connectionString);
            //Scan if anyone has birthday
            Scan4BDay();
        }

        //______________________________________________________
        private void timer1_Tick(object sender, EventArgs e)
        {
            //Show date upper left corner
            DateLabel.Text = DateTime.Now.ToString();
            timer1.Start();
        }
        
        //______________________________________________________
        private void SaveButton_Click(object sender, EventArgs e)
        {
            //Check if requested values are properly seted and procced to add();
            if (FNameTextBox.Text != "")
            {
                if (LNameTextBox.Text != "")
                {
                    if(NumberOnly(PhoneTextBox.Text))
                    {
                        if (!Existance())
                        {
                            if (CheckEMail(EMailTextBox.Text))
                            {
                                if (NumberOnly(ZCodeTextBox.Text))
                                {
                                    add();
                                    ShowButton.PerformClick();
                                }
                                else
                                {
                                    MessageBox.Show("Provide a valid Zip Code!");
                                }
                            }
                            else
                            {
                                MessageBox.Show("Please provide a valid E-Mail address!");
                            }
                        }
                    }
                    else
                    {
                        MessageBox.Show("Please provide a valid phone number");
                    }
                }
                else
                {
                    MessageBox.Show("Please provide a Last Name!");
                }
            }
            else
            {
                MessageBox.Show("Please provide a First Name!");
            }
        }

        //______________________________________________________
        bool NumberOnly(string s)
        {
            //Check if the given string contains only numbers
            int val;
            return int.TryParse(s, out val);
        }

        //______________________________________________________
        bool Existance()
        {
            //Check the database if the PHone keyword already exists
            flag = false;
            connection.Open();
            String query = "Select * from Table1";
            OleDbCommand command = new OleDbCommand(query, connection);
            OleDbDataReader reader = command.ExecuteReader();
            StringBuilder builder = new StringBuilder();
            while (reader.Read())
            {
                if (Convert.ToInt32(PhoneTextBox.Text) == reader.GetInt32(3))
                {
                    flag = true;
                    break;
                }
            }
            connection.Close();
            if (flag)
            {
                MessageBox.Show("Phone already exists in the catalog");
            }
            return flag;
        }

        //______________________________________________________
        void add()
        {
            //add to database the followinds based on the key
            connection.Open();
            String query = "Insert into Table1(FName,LName,Phone,EMail,Address,City,ZCode,BDay,Photo,Music) " +
                "values ('" + FNameTextBox.Text + "','" + LNameTextBox.Text + "'," +
                "'" + Convert.ToInt32(PhoneTextBox.Text) + "', '" + EMailTextBox.Text + "'," +
                "'" + AddressTextBox.Text + "','" + CityTextBox.Text + "'," +
                "'" + Convert.ToInt32(ZCodeTextBox.Text) + "'," +
                "'" + BDay.Value.ToString() + "', '" + photo + "', '" + music + "' )";

            OleDbCommand command = new OleDbCommand(query, connection);
            int count = command.ExecuteNonQuery();
            connection.Close();
            MessageBox.Show(count.ToString() + " Contact added successfully!");
            ShowButton.PerformClick();
        }

        //______________________________________________________
        private void PhotoBox_Click(object sender, EventArgs e)
        {
            //Insert path image to string photo via dialog
            OpenFileDialog dialog = new OpenFileDialog();
            dialog.Filter = "All image filters(*.jpeg)|*.jpeg|(*.png)|*.png|(*.jpg)|*.jpg";
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                photo = dialog.FileName;
                PhotoBox.Image = Image.FromFile(@photo);
            }
        }

        //______________________________________________________
        private void MusicButton_Click(object sender, EventArgs e)
        {
            //Insert path music to string music via dialog
            OpenFileDialog dialog = new OpenFileDialog();
            dialog.Filter = "All audio filters(*.mp3)|*.mp3|(*.wav)|*.wav|(*.flac)|*.flac";
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                music = dialog.FileName;
            }
        }

        //______________________________________________________
        private void HomeButton_Click(object sender, EventArgs e)
        {
            //Hide some gui things or show them
            ClearAllTextBoxes();
            HomeScreen(true);
            ShowScreen(false);
            SearchScreen(false);
            EditButtons(false);
        }

        //______________________________________________________
        private void ShowButton_Click(object sender, EventArgs e)
        {
            //Print evey contact in database to RichTextBox
            ClearAllTextBoxes();
            HomeScreen(false);
            ShowScreen(true);
            SearchScreen(false);
            EditButtons(false);

            connection.Open();
            String query = "Select * from Table1";
            OleDbCommand command = new OleDbCommand(query, connection);
            OleDbDataReader reader = command.ExecuteReader();
            StringBuilder builder = new StringBuilder();
            while (reader.Read())
            {
                builder.AppendLine(reader.GetString(1) + " | " + reader.GetString(2) +
                " | " + reader.GetInt32(3) + " | " + reader.GetString(4) +
                " | " + reader.GetString(5) + " | " + reader.GetString(6) +
                " | " + reader.GetInt32(7) + " | " + reader.GetString(8));
            }
            connection.Close();
            RichTextBox.Clear();
            RichTextBox.AppendText(builder.ToString());
        }

        //______________________________________________________
        private void SearchButton_Click(object sender, EventArgs e)
        {
            //Hide some gui things or show them
            ClearAllTextBoxes();
            HomeScreen(false);
            ShowScreen(false);
            SearchScreen(true);
            EditButtons(false);
        }

        //______________________________________________________
        private void RemoveButton_Click(object sender, EventArgs e)
        {
            //Remove all contacts
            DialogResult dialogResult = MessageBox.Show("Are you sure you want to delete all your contacts?", "Remove everything?", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                connection.Open();
                string comand = "DELETE FROM Table1";
                OleDbCommand cmd = new OleDbCommand(comand, connection);
                cmd.ExecuteNonQuery();
                connection.Close();
                ClearAllTextBoxes();
                ShowButton.PerformClick();

            }
        }

        //______________________________________________________
        void ClearAllTextBoxes()
        {
            //Empty all text boxes
            FNameTextBox.Text = String.Empty;
            LNameTextBox.Text = String.Empty;
            PhoneTextBox.Text = String.Empty;
            EMailTextBox.Text = String.Empty;
            AddressTextBox.Text = String.Empty;
            CityTextBox.Text = String.Empty;
            ZCodeTextBox.Text = String.Empty;
            player1.controls.pause();
            PhotoBox.Image = null;
            BDay.Text = String.Empty;
            
            FNameSearchTextBox.Text = String.Empty;
            LNameSearchTextBox.Text = String.Empty;
            PhoneSearchTextBox.Text = String.Empty;
        }

       //______________________________________________________
        void Scan4BDay()
        {
            //Check if anyone has birthday
            connection.Open();
            String query = "Select * from Table1";
            OleDbCommand command = new OleDbCommand(query, connection);
            OleDbDataReader reader = command.ExecuteReader();
            StringBuilder builder = new StringBuilder();

            String sDate = DateTime.Now.ToString();
            DateTime datevalue = (Convert.ToDateTime(sDate.ToString()));
            String current = datevalue.Month.ToString() + "/" + datevalue.Day.ToString();
            while (reader.Read())
            {
                if (current == reader.GetString(8).Substring(0, 5))
                {
                    player1.URL = @reader.GetString(10);
                    player1.controls.play();
                    DialogResult dialogResult = MessageBox.Show(reader.GetString(1) + " " + reader.GetString(2) + " Has Birthday!", "Birtday Notification!", MessageBoxButtons.YesNo);
                    if (dialogResult == DialogResult.Yes)
                    {
                        player1.controls.pause();
                    }
                }
            }
            connection.Close();
        }

        //______________________________________________________
        void HomeScreen(bool flag)
        {
            //Hide some gui things or show them
            FNameLabel.Visible = flag;
            FNameTextBox.Visible = flag;

            LNameLabel.Visible = flag;
            LNameTextBox.Visible = flag;

            PhoneLabel.Visible = flag;
            PhoneTextBox.Visible = flag;

            EMailLabel.Visible = flag;
            EMailTextBox.Visible = flag;

            AddressLabel.Visible = flag;
            AddressTextBox.Visible = flag;

            CityLabel.Visible = flag;
            CityTextBox.Visible = flag;

            ZCodeLabel.Visible = flag;
            ZCodeTextBox.Visible = flag;

            BDayLabel.Visible = flag;
            BDay.Visible = flag;

            PhotoLabel.Visible = flag;
            PhotoBox.Visible = flag;

            MusicButton.Visible = flag;

            SaveButton.Visible = flag;
            player1.controls.pause();
        }

        //______________________________________________________
        void ShowScreen(bool flag)
        {
            //Hide some gui things or show them
            RichTextBox.Visible = flag;
            player1.controls.pause();
        }

        //______________________________________________________
        void SearchScreen(bool flag)
        {
            //Hide some gui things or show them
            FNameSearchLabel.Visible = flag;
            FNameSearchTextBox.Visible = flag;

            LNameSearchLabel.Visible = flag;
            LNameSearchTextBox.Visible = flag;

            PhoneSearchLabel.Visible = flag;
            PhoneSearchTextBox.Visible = flag;

            SearchCButton.Visible = flag;
            player1.controls.pause();
        }

        //______________________________________________________
        void EditButtons(bool flag)
        {
            EditButton.Visible = flag;
            DeleteButton.Visible = flag;
        }

        //______________________________________________________
        private void SearchCButton_Click(object sender, EventArgs e)
        {
            //Input 3 parameters and check if the contact exists. Then you can remove or edit that contact
            connection = new OleDbConnection(connectionString);
            flag = false;
            connection.Open();
            String query = "Select * from Table1";
            OleDbCommand command = new OleDbCommand(query, connection);
            OleDbDataReader reader = command.ExecuteReader();
            StringBuilder builder = new StringBuilder();
            if ((PhoneSearchTextBox.Text != "") && (FNameSearchTextBox.Text != "") && (LNameSearchTextBox.Text != ""))
            {
                while (reader.Read())
                {
                    if(NumberOnly(PhoneSearchTextBox.Text))
                    {
                        if ((Convert.ToInt32(PhoneSearchTextBox.Text) == reader.GetInt32(3)) && (FNameSearchTextBox.Text == reader.GetString(1)) && (LNameSearchTextBox.Text == reader.GetString(2)))
                        {
                            FNameTextBox.Text = reader.GetString(1);
                            LNameTextBox.Text = reader.GetString(2);
                            PhoneTextBox.Text = reader.GetInt32(3).ToString();
                            EMailTextBox.Text = reader.GetString(4);
                            AddressTextBox.Text = reader.GetString(5);
                            CityTextBox.Text = reader.GetString(6);
                            ZCodeTextBox.Text = reader.GetInt32(7).ToString();
                            BDay.Text = reader.GetString(8);
                            if ((reader.GetString(9) != null) && (reader.GetString(9) != ""))
                            {
                                PhotoBox.Image = Image.FromFile(@reader.GetString(9));
                            }
                            if ((reader.GetString(10) != null) && (reader.GetString(10) != ""))
                            {
                                player1.URL = @reader.GetString(10);
                                player1.controls.play();
                            }
                            flag = true;
                            break;
                        }
                    }
                }
            }
            else
            {
                MessageBox.Show("Please provide First Name, Last Name and a phone number!");
            }
            connection.Close();
            if (!flag)
            {
                MessageBox.Show("Contact does not exist!");
            }
            EditButton.Visible = true;
            DeleteButton.Visible = true;
            SearchScreen(false);
            ShowScreen(false);
            HomeScreen(true);
        }

        //______________________________________________________
        private void EditButton_Click(object sender, EventArgs e)
        {
            //Delete and add again the contact... That's an update ;P
            DialogResult dialogResult = MessageBox.Show("Are you sure you want to edit the contact?", "Edit?", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                connection.Open();
                String query = "Delete from Table1 Where Phone=" + Convert.ToInt32(PhoneTextBox.Text) + "";
                OleDbCommand command = new OleDbCommand(query, connection);
                command.Parameters.AddWithValue("Phone", Convert.ToInt32(PhoneTextBox.Text));
                command.ExecuteNonQuery();
                connection.Close();
            }
            EditButton.Visible = false;
            DeleteButton.Visible = false;
        }

        //______________________________________________________
        private void DeleteButton_Click(object sender, EventArgs e)
        {
            //Delete a specific contact
            DialogResult dialogResult = MessageBox.Show("Are you sure you want to delete the contact?", "Delete?", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                Keep();
                connection.Open();
                String query = "Delete from Table1 Where Phone=" + Convert.ToInt32(PhoneTextBox.Text) + "";
                OleDbCommand command = new OleDbCommand(query, connection);
                command.Parameters.AddWithValue("Phone", Convert.ToInt32(PhoneTextBox.Text));
                command.ExecuteNonQuery();
                connection.Close();
                ClearAllTextBoxes();
            }
            DeleteButton.Visible = false;
            EditButton.Visible = false;
        }

        //______________________________________________________
        bool CheckEMail(string EMail)
        {
            //Check if email contains the following
            if ( ( EMail.Contains("@") && (  (EMail.Contains(".com") ) || (EMail.Contains(".org")) || (EMail.Contains(".gr"))  )  ) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        void Keep()
        {
            connection = new OleDbConnection(connectionString);
            connection.Open();
            String query = "Select * from Table1";
            OleDbCommand command = new OleDbCommand(query, connection);
            OleDbDataReader reader = command.ExecuteReader();
            StringBuilder builder = new StringBuilder();
            while (reader.Read())
            {
                if(Convert.ToInt32(PhoneTextBox.Text) == reader.GetInt32(3))
                {
                    photo = reader.GetString(9);
                    music = reader.GetString(10);
                }
            }
            connection.Close();
        }
    }
}
