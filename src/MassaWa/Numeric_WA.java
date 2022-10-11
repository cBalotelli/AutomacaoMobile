package MassaWa;

//import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Henrique
 */
public class Numeric_WA extends PlainDocument {

    private int limite;

    public Numeric_WA(int maxLen) {
        super();
        if (maxLen <= 0) {
            throw new IllegalArgumentException("Valor Invalido");
        }
        limite = maxLen;
    }

    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
            throws BadLocationException {
        if (str == null || getLength() == limite) {
            return;
        }
        int totalquantia = (getLength() + str.length());
        if (totalquantia <= limite) {
            super.insertString(offset, str.replaceAll("[^0-9]", "\n"), attr);
            return;
        }
        String nova = str.substring(0, getLength() - limite);
        super.insertString(offset, nova, attr);
    }
}
