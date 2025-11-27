class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getTotalItems() {
        return products.size();
    }

    public void printItemNames() {
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
}
