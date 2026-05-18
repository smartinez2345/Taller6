package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
        // Organiza el panel en 3 filas, 1 columna (una por cada dato del restaurante)
        setLayout( new GridLayout( 3, 1 ) );

        // Configura la etiqueta para el nombre
        JPanel filaNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaNombre.add( new JLabel( "Nombre: " ) );
        labNombre = new JLabel( "" );
        filaNombre.add( labNombre );
        add( filaNombre );

        // Configura la etiqueta para la calificación (muestra imagen de estrellas)
        JPanel filaCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaCalificacion.add( new JLabel( "Calificación: " ) );
        labCalificacion = new JLabel( );
        filaCalificacion.add( labCalificacion );
        add( filaCalificacion );

        // Configura el checkbox para indicar si ya se visitó o no el restaurante
        JPanel filaVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaVisitado.add( new JLabel( "Visitado: " ) );
        chkVisitado = new JCheckBox( );
        chkVisitado.setEnabled( false ); // Solo lectura, el usuario no puede modificarlo aquí
        filaVisitado.add( chkVisitado );
        add( filaVisitado );
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     * @param nombre El nombre del restaurante
     * @param calificacion La calificación del restaurante (1 a 5)
     * @param visitado Si el restaurante ya fue visitado o no
     */
    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( buscarIconoCalificacion( calificacion ) );
        chkVisitado.setSelected( visitado );
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante( Restaurante r )
    {
        this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que muestra la calificación
     * @param calificacion La calificación del restaurante, que debe ser un número entre 1 y 5.
     * @return Una imagen a la que corresponde la calificación
     */
    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}