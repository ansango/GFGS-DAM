using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace UF1_PAC3_2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        private void calcu_click(object sender, EventArgs evento)
        {
            if (this.centi.Text.Length > 0)
            {
                float centigradosG = float.Parse(this.centi.Text);
                float farenheitG = (centigradosG * 9 / 5) + 32;
                this.faren.Text = farenheitG.ToString();
            }
            else if (this.faren.Text.Length > 0)
            {
                float farenheitG = float.Parse(this.faren.Text);
                float centigradosG = (farenheitG - 32) * 5 / 9;
                this.centi.Text = centigradosG.ToString();
            }
            else
            {
                this.centi.Text = "0";
                calcu_click(sender, evento);
            }
        }
    }
}
