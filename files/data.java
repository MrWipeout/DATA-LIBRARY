/*
 * Athanasios Exizoglou
 */

package files;


public class data {
        private String titlos;
        private String ISBN;
        private String  suggrafeas;
        private String etos;
        private String perigrafh;
        private String eidos;
        private String arithmosSelidwn;
        private String thesh;

        public data(){
        
        }
        
    public data(String titlos, String ISBN, String suggrafeas, String etos, String perigrafh, String eidos, String arithmosSelidwn, String thesh) {
        this.titlos = titlos;
        this.ISBN = ISBN;
        this.suggrafeas = suggrafeas;
        this.etos = etos;
        this.perigrafh = perigrafh;
        this.eidos = eidos;
        this.arithmosSelidwn = arithmosSelidwn;
        this.thesh = thesh;
    }

    public String getTitlos() {
        return titlos;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getSuggrafeas() {
        return suggrafeas;
    }

    public String getEtos() {
        return etos;
    }

    public String getPerigrafh() {
        return perigrafh;
    }

    public String getEidos() {
        return eidos;
    }

    public String getArithmosSelidwn() {
        return arithmosSelidwn;
    }

    public String getThesh() {
        return thesh;
    }

    @Override
    public String toString() {
        return "data{" + "titlos=" + titlos + ", ISBN=" + ISBN + ", suggrafeas=" + suggrafeas + ", etos=" + etos + ", perigrafh=" + perigrafh + ", eidos=" + eidos + ", arithmosSelidwn=" + arithmosSelidwn + ", thesh=" + thesh + '}';
    }
        


        


        
            
    
}
