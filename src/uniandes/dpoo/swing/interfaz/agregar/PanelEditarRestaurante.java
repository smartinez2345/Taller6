package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Organiza el panel en 3 filas, 1 columna
        setLayout( new GridLayout( 3, 1 ) );

        // Crea el campo para el nombre con una etiqueta al frente
        JPanel filaNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaNombre.add( new JLabel( "Nombre" ) );
        txtNombre = new JTextField( 15 );
        filaNombre.add( txtNombre );
        add( filaNombre );

        // Crea el selector para la calificación con una etiqueta al frente
        JPanel filaCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaCalificacion.add( new JLabel( "Calificación" ) );
        cbbCalificacion = new JComboBox<>( new String[]{ "1", "2", "3", "4", "5" } );
        filaCalificacion.add( cbbCalificacion );
        add( filaCalificacion );

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        JPanel filaVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        filaVisitado.add( new JLabel( "Visitado" ) );
        cbbVisitado = new JComboBox<>( new String[]{ "Sí", "No" } );
        filaVisitado.add( cbbVisitado );
        add( filaVisitado );
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return true si fue visitado, false si no
     */
    public boolean getVisitado( )
    {
        return cbbVisitado.getSelectedItem( ).equals( "Sí" );
    }

    /**
     * Indica la calificación marcada en el selector
     * @return La calificación como entero entre 1 y 5
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return El nombre del restaurante
     */
    public String getNombre( )
    {
        return txtNombre.getText( );
    }
}