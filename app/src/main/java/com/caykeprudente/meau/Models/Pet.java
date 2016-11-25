package com.caykeprudente.meau.Models;

/**
 * Created by cayke on 03/11/16.
 */

public class Pet {
    //card info
    private String name, sex, age, size, location, species;
    private Boolean liked;
    private int imageResource;

    //complete info
    private Boolean cut, dewormed, vaccinated;
    private String diseases, humor, donor_requirements, description;


    public Pet (String name, String sex, String age, String size, String location, int imageResource, Boolean liked, String species)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.size = size;
        this.location = location;
        this.imageResource = imageResource;
        this.liked = liked;
        this.species = species;

        completeInfo();
    }

    public void completeInfo()
    {
        this.cut = false;
        this.dewormed = true;
        this.vaccinated = true;
        this.diseases = "Nenhuma";
        this.humor = "Calmo e dócil";
        this.donor_requirements = "Termo de adocao, fotos da casa, visista previa e acompanhamento durante tres meses.";
        this.description = "É um animal muito docil e de facil convivencia. Adora caminhadas e se da muito bem com criancas. Tem medo de raios e chuvas, necessitando de atencao nesses momentos. Está disponivel pois foi encontrado na rua e nao podemos mante-lo em casa por ja ter outros 14 animais.";
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public String getSpecies() {
        return species;
    }

    public Boolean getLiked() {
        return liked;
    }

    public Boolean getCut() {
        return cut;
    }

    public Boolean getDewormed() {
        return dewormed;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public String getDiseases() {
        return diseases;
    }

    public String getHumor() {
        return humor;
    }

    public String getDonor_requirements() {
        return donor_requirements;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
