To run the tests: mvn test "-DsuiteXmlFile=testng-regression.xml" "-Dbrowser=firefox" "-Denvironment=dev"


## S.O.L.I.D. Refactor Summary - Driver package

| **Class** | **Problem (Violation)** | **Solution (Fix According to S.O.L.I.D.)** |
|----------|--------------------------|---------------------------------------------|
| `DriverSingleton` | **SRP violation** — the class handled too many responsibilities: browser selection, driver initialization, lifecycle management, WebDriverManager setup, event listeners, window control, and singleton logic. | Split into dedicated classes: `DriverManager` (lifecycle), `DriverFactory` (driver creation), and browser-specific `DriverStrategy` implementations. Each class now has a single responsibility. |
| `DriverSingleton` | **OCP violation** — adding a new browser required modifying an internal `switch-case`. | Replaced `switch-case` with **Factory + Strategy pattern**. Adding a new browser now requires adding a new strategy class without modifying existing logic. |
| `DriverSingleton` | **DIP violation** — code depended on concrete driver implementations (`new ChromeDriver()`, etc.). | Introduced `DriverStrategy` interface; high-level code depends on abstractions rather than concrete driver classes. |
| `DriverSingleton` | **LSP violation (indirect)** — tightly coupled browser creation prevented substituting driver types freely. | Strategy classes implement `DriverStrategy`, enabling safe substitution of browser drivers. |
| `DriverSingleton` | **Singleton anti-pattern issues** — global state + ThreadLocal made debugging and testing difficult. | Replaced with `DriverManager` using clean `ThreadLocal<WebDriver>` management and removed singleton responsibilities. |

## S.O.L.I.D. Refactor Summary – CheckoutStepOnePageTest

| **Class / Test** | **Problem (Violation)** | **Solution (Fix According to S.O.L.I.D.)** |
|-----------------|------------------------|--------------------------------------|
| `CheckoutStepOnePageTest` | **Single Responsibility Principle (SRP) partially violated** – Each test repeats the same setup steps: login, add items to cart, open checkout, click checkout. | Extracted common pre-test steps into a **helper method** (`fillCartAndGoToCheckout()`) to reduce repetition and isolate test logic. |
| `CheckoutStepOnePageTest` | **Open/Closed Principle (OCP) partially violated** – Adding new test variations (e.g., filling only certain fields) previously required creating new `fillCheckoutWithX` methods in the Page Object. | Introduced a **flexible `fillCheckoutForm(firstName, lastName, postalCode)`** method that can accept `null` for skipped fields. Tests can now add new variations without changing the Page Object. |
| `CheckoutStepOnePageTest` | **Dependency Inversion Principle (DIP) partially violated** – Test directly depends on concrete Page Object implementations. | Page Objects receive `WebDriver` via **constructor injection**. Tests remain high-level and do not depend on lower-level driver implementation details. |
| `CheckoutStepOnePageTest` | **Liskov Substitution Principle (LSP) / Interface Segregation Principle (ISP)** – no major violations. | Maintained: each Page Object behaves as expected and exposes only relevant methods for the tests. |
| `CheckoutStepOnePageTest` | **Code duplication** – Multiple tests repeating identical sequences. | Refactored setup steps into **helper methods**; reused `fillCheckoutForm` in all test variations. |



