package wsb;

public enum Country {
    US("English", "USA", 21000000000000L),
    POLAND("Polish", "POL", 595000000000L),
    GERMANY("German", "DEU", 3000000000000L),
    SPAIN("Spanish", "ESP", 1000000000000L);
    final String language;
    final String countryCode;
    final long gdp;

    Country(String language, String countryCode, long gdp) {
        this.language = language;
        this.countryCode = countryCode;
        this.gdp = gdp;
    }

    public long gdpInPLN() {
        return (long) (gdp * 3.71);
    }
}