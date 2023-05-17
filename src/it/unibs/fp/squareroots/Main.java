package it.unibs.fp.squareroots;


import it.kibo.fp.lib.InputData;

public class Main {
    public static void main(String[] args) {
        do {
            AlberoBinario albero = new AlberoBinario();
            int numLivelli = InputData.readIntegerBetween("Selezionare la complessità " +
                    "dell'espressione (1 a 4): ", 1, 4);
            albero.generaAlberoRandom(numLivelli);

            System.out.println();
            System.out.println("Espressione generata: ");
            albero.visualizzaEspressione();
            System.out.println();

            if (InputData.readYesOrNo("Visualizzare la soluzione dell'espressione")) {
                try {
                    System.out.println(albero.assegnaValoreEspressione());
                }
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }

            }

        } while(InputData.readYesOrNo("Generare una nuova espressione"));



    }
}
