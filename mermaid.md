classDiagram
    class CardAccount {
        +String accountNumber
        +String cardHolderName
        +double balance
        +String cardType
        +String expirationDate
        +validateCard()
        +charge(double amount)
        +makePayment(double amount)
        +checkBalance()
    }

    class Transaction {
        +String transactionId
        +Date transactionDate
        +double amount
        +String type
        +makeTransaction()
    }

    class CardHolder {
        +Long id
        +String name
        +String address
        +String phoneNumber
        +List~CardAccount~ cardAccounts
        +addCardAccount(CardAccount account)
        +removeCardAccount(String accountNumber)
        +getCardAccounts()
    }

    CardAccount --> Transaction : has
    CardHolder --> CardAccount : owns