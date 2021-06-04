
package CapaLogica;

/**
 *
 * @author Gabriela
 */
public enum ExtraAdicional {
    Papas(200),
    ArosDeCebolla(200){
        public String toStirng(){
            return"Aros de cebolla";
        }
    },
    Yuquitas(250),
    Postre(200);
    
    private double precioAdic;

    private ExtraAdicional(double precioAdic) {
        this.precioAdic = precioAdic;
    }

    public double getPrecioAdic() {
        return precioAdic;
    }
    
    
}
