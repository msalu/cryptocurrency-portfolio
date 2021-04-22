## Cryptocurrency Portfolio

**1. Clone the application**
```bash
https://github.com/msalu/cryptocurrency-portfolio.git
```

**2. Run**
```bash
src / main / java / com / mark / cryptoportfolio / Cryptoportfolio.java
```

**3. Database**
```bash
Database: H2
```

+ Go to browser:  `http://localhost:8080/h2-ui`
+ JDBC URL: `jdbc:h2:mem:cryptodb`
+ Username: `sa`
+ Password: `leave empty`
+ In Login window click: `Connect`


**4. Endpoints**


| Method | Url | Description |
| ------ | --- | ----------- | 
| GET    | http://localhost:8080/v1/portfolio/get-all | Get all portfolios from database | 
| GET    | http://localhost:8080/v1/portfolio/get | Get portfolio by id | 
| GET | http://localhost:8080/v1/portfolio/bitfinex | Get cryptocurrencies last market prices |
| POST    | http://localhost:8080/v1/portfolio/create | Create a new portfolio |
| PUT  | http://localhost:8080/v1/portfolio/update | Update existing portfolio |
| DELETE    | http://localhost:8080/v1/portfolio/delete | Delete portfolio |




#### Samples of URLs with valid JSON Request Body's

Get Portfolios 
```bash
http://localhost:8080/v1/portfolio/get-all
```

Get Portfolio By Id
```bash
http://localhost:8080/v1/portfolio/get/1
```

Get Cryptocurrency's Last Market Price From Bitfinex Public API
```bash
http://localhost:8080/v1/portfolio/bitfinex?symbols=btceur
```
** Query  KEY  is `symbols` and for VALUES reference check `https://docs.bitfinex.com/v1/reference#rest-public-symbols`   **

Create Portfolio
```bash
http://localhost:8080/v1/portfolio/create

{
    "symbols": "btc",
    "amount": "10.00",
    "wallet": "bitcoin",
  
}
```
** Datetime is fetched automatically  **

Change Portfolio
```bash
http://localhost:8080/v1/portfolio/update/1
{
    "symbols": "eth",
    "amount": "15.00",
    "wallet": "ethereum",
}
```

Delete Portfolio
```bash
http://localhost:8080/v1/portfolio/delete/2
```
