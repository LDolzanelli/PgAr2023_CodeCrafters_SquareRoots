package it.unibs.fp.squareroots;

import java.util.Random;

public class AlberoBinario {

    //Node principale dalla quale parte l'albero
    private AlberoNode radice;

    public AlberoBinario() {
        this.radice = null;
    }

    public void generaAlberoRandom(int numLivelli) {
        Random random = new Random();
        radice = generaAlberoRandom(random, numLivelli);
    }

    private AlberoNode generaAlberoRandom(Random random, int numLivelli) {
        //Alla base dell'albero vengono assegnati i numeri
        if (numLivelli == 0) {
            return new AlberoNode(String.valueOf(random.nextInt(9) + 1));
        }

        AlberoNode node = new AlberoNode(generaOperatoreRandom(random));

        //Il metodo riparte con un livello in meno, sia a sinistra che a destra finchè è completo
        node.sinistro = generaAlberoRandom(random, numLivelli - 1);
        node.destro = generaAlberoRandom(random, numLivelli - 1);

        return node;
    }

    private String generaOperatoreRandom(Random random) {
        String[] operandi = {"+", "-", "*", "/"};
        int indice = random.nextInt(operandi.length);
        return operandi[indice];
    }

    public int assegnaValoreEspressione() {
        //metodo base che parte dalla radice, cicla finchè alla radice non viene assegnato un valore int
        return assegnaValoreEspressione(radice);
    }

    private int assegnaValoreEspressione(AlberoNode node) {
        if (node.isOperando()) {

            int valoreSinistro = assegnaValoreEspressione(node.sinistro);
            int valoreDestro = assegnaValoreEspressione(node.destro);

            switch (node.valore) {
                case "+":
                    return (valoreSinistro + valoreDestro);
                case "-":
                    return (valoreSinistro - valoreDestro);
                case "*":
                    return (valoreSinistro * valoreDestro);
                case "/":
                    //Evita eventuali divisioni per zero
                    if(valoreDestro == 0) {
                        throw new ArithmeticException(" Attenzione: Divisione per zero, espressione non risolvibile");
                    }
                    return (valoreSinistro / valoreDestro);
                default:
                    throw new IllegalArgumentException("Invalid operator: " + node.getValore());

            }
        } else {
            return Integer.parseInt(node.getValore());
        }
    }

    public void visualizzaEspressione() {
        visualizzaEspressione(radice);
    }
    private void visualizzaEspressione(AlberoNode node) {
        if (node.isOperando()) {
            System.out.print("( ");
        }

        if (node.sinistro != null) {
            visualizzaEspressione(node.sinistro);
        }

        System.out.print(" " + node.getValore() + " ");

        if (node.sinistro != null) {
            visualizzaEspressione(node.destro);
        }

        if (node.isOperando()) {
            System.out.print(" )");
        }

    }
}

