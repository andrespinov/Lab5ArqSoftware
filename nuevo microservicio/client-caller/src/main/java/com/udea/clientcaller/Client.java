package com.udea.clientcaller;

class Client{

    private long id;
    private String clientName;
    private String email;
    private String cellNumber;

    @Override
    public String toString() {
        return "A client{"
                + "id:" + id
                + ", clientName='" + clientName
                + ", email='" + email
                + ", cellNumber='" + cellNumber + '\''
                + '}';
    }

    public Client() {
    }

    public Client(long id, String clientName, String email, String cellNumber) {
        this.id = id;
        this.clientName = clientName;
        this.email = email;
        this.cellNumber = cellNumber;
    }

    public long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    
}
