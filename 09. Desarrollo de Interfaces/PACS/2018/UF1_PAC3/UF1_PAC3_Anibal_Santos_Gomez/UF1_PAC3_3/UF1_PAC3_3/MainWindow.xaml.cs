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

namespace UF1_PAC3_3
{
    public partial class MainWindow : Window
    {
        private float dinero;

        public event EventHandler dineroCambiado;

        public MainWindow()
        {
            InitializeComponent();
        }

        protected virtual void dineroCambia() //clase virtual vacia
        {
            if (dineroCambiado != null) //
            {
                dineroCambiado(this, EventArgs.Empty);
            }
            else
            {
                if (Dinero < 0)
                {
                    MessageBox.Show("No tienes saldo suficiente en tu haber: " + Dinero.ToString(), "Advertencia // Warning", MessageBoxButton.OK, MessageBoxImage.Warning);
                }
            }
        }
        public float Dinero // getters y setters
        {
            get
            {
                return dinero; 
            }

            set
            {
                dinero = value;
                dineroCambia();
            }
        }

        // Botones de eventos
        private void ingresarClick(object sender, RoutedEventArgs evento)
        {
            float cant = float.Parse(this.cantidad.Text);
            this.cantidad.Text = "";
            Dinero = Dinero + cant;
        }
        private void retirarClick(object sender, RoutedEventArgs evento)
        {
            float cant = float.Parse(this.cantidad.Text);
            this.cantidad.Text = "";
            Dinero = Dinero - cant;
        }
    }
}
