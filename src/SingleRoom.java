class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0, 5);
    }

    public String getRoomType() {
        return "Single Room";
    }
}