/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubigan;

import javax.swing.text.*;

/**
 *
 * @author DANEM682
 */
public class JTextFieldLimit extends PlainDocument {

    public int textLimit;JTextFieldLimit(int textLimit) {
        super();
        this.textLimit = textLimit;
    }

    JTextFieldLimit(int textLimit, boolean upper) {
        super();
        this.textLimit = textLimit;
    }

    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= textLimit) {
            super.insertString(offset, str, attr);
        }
    }
}
