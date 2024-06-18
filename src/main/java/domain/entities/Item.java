package domain.entities;

public class Item {

  private Long idItem;

  private String category;

  private String description;

  private double price;

  private double width;

  private double height;

  private double length;

  private double weight;

  public Item(Long idItem, String category, String description, double price, double width, double height,
              double length, double weight) {
    this.idItem = idItem;
    this.category = category;
    this.description = description;
    this.price = price;
    this.width = width;
    this.height = height;
    this.length = length;
    this.weight = weight;
  }

  public Item(Long idItem, String description, String category, double price) {
    this.idItem = idItem;
    this.description = description;
    this.category = category;
    this.price = price;
  }

  public Long getIdItem() {
    return idItem;
  }

  public void setIdItem(Long idItem) {
    this.idItem = idItem;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getVolume() {
    double width = this.getWidth() / 100.0;
    double height = this.getHeight() / 100.0;
    double length = this.getLength() / 100.0;
    return width * height * length;
  }

  public double getDensity() {
    return Math.round((this.weight / this.getVolume()) * 100.0) / 100.0;
  }
}
