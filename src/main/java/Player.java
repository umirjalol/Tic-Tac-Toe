public abstract class Player {
    protected String name;
    protected String mov;

    public abstract void play(String[] board);

    public void setMov(String mov) {
        this.mov = mov;
    }

    public String getMov() {
        return mov;
    }

    @Override
    public String toString() {
        return name ;
    }
}