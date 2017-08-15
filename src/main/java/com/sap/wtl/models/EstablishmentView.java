package com.sap.wtl.models;

public class EstablishmentView extends Establishment{
    private int countOfVotes;

    public EstablishmentView(Establishment establishment,int countOfVotes) {
        super(
                establishment.getId(),
                establishment.getName(),
                establishment.getAddress(),
                establishment.getAveragePrice(),
                establishment.isAleloAccepted(),
                establishment.getImage(),
                establishment.getVote());

        this.countOfVotes = countOfVotes;
    }

    public int getCountOfVotes() {
        return countOfVotes;
    }

    public void setCountOfVotes(int countOfVotes) {
        this.countOfVotes = countOfVotes;
    }
}
