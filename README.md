To run the tests: mvn test "-DsuiteXmlFile=testng-regression.xml" "-Dbrowser=firefox" "-Denvironment=dev"


## S.O.L.I.D. Refactor Summary

| **Class** | **Problem (Violation)** | **Solution (Fix According to S.O.L.I.D.)** |
|----------|--------------------------|---------------------------------------------|
| `DriverSingleton` | **SRP violation** — the class handled too many responsibilities: browser selection, driver initialization, lifecycle management, WebDriverManager setup, event listeners, window control, and singleton logic. | Split into dedicated classes: `DriverManager` (lifecycle), `DriverFactory` (driver creation), and browser-specific `DriverStrategy` implementations. Each class now has a single responsibility. |
| `DriverSingleton` | **OCP violation** — adding a new browser required modifying an internal `switch-case`. | Replaced `switch-case` with **Factory + Strategy pattern**. Adding a new browser now requires adding a new strategy class without modifying existing logic. |
| `DriverSingleton` | **DIP violation** — code depended on concrete driver implementations (`new ChromeDriver()`, etc.). | Introduced `DriverStrategy` interface; high-level code depends on abstractions rather than concrete driver classes. |
| `DriverSingleton` | **LSP violation (indirect)** — tightly coupled browser creation prevented substituting driver types freely. | Strategy classes implement `DriverStrategy`, enabling safe substitution of browser drivers. |
| `DriverSingleton` | **Singleton anti-pattern issues** — global state + ThreadLocal made debugging and testing difficult. | Replaced with `DriverManager` using clean `ThreadLocal<WebDriver>` management and removed singleton responsibilities. |




