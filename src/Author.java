public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Author author= (Author) o;
        if (this.firstName.equals(author.firstName) &&
                this.lastName.equals(author.lastName)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        String string = this.firstName + this.lastName;
        int result = string == null ? 0 : string.hashCode();
        result = 31 * result;
        return result;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}