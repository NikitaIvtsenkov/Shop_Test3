/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21shop3;

/**
 *
 * @author pupil
 */
public class JPTV21Shop3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            "base".equals(args[0]); 
            App.saveToBase = true;
        } catch (Exception e) {
            App.saveToBase = false;
        }
       
        App app = new App();
        app.run();
    }
    
}
    

