package it.unibs.fp.squareroots;

class AlberoNode {
    String valore;
    AlberoNode sinistro;
    AlberoNode destro;

    public AlberoNode(String valore) {
        this.valore = valore;
        this.sinistro = null;
        this.destro = null;
    }

    public boolean isOperando() {
        // Check if the node is an operator
        return valore.equals("+") || valore.equals("-") || valore.equals("*") || valore.equals("/");
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }
}
