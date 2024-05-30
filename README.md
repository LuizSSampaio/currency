# Currency Converter

This Java project is a simple currency converter application created to reinforce basic Java concepts, work with dependencies (using Gradle), handle JSON data, and make API calls.

## Project Description

The Currency Converter application allows users to convert an amount from one currency to another using the latest exchange rates fetched from an online API. The application takes the original currency code, the amount to be converted, and the target currency code as input, and then displays the converted amount.

### Running the Application

1. The program will prompt you to enter the original currency code, the amount to convert, and the target currency code.

    ```
    CURRENCY CONVERTER
    Original Currency Code: usd
    Value: 100
    Target Currency Code: eur
    ```

2. The application will fetch the latest exchange rates and display the converted amount.

    ```
    100.00 usd correspond to 90.50 eur
    ```

## Acknowledgments

- [Jackson](https://github.com/FasterXML/jackson) for JSON processing.
- [Exchange API](https://github.com/fawazahmed0/exchange-api) for providing exchange rate data.
- [Gradle](https://gradle.org/) for dependency management and build automation.
