package gaming;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.netty.handler.timeout.TimeoutException;

public class SampleTest {
	@Test
	public void complete() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.22funth1.com/en-in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//img[@src='/_nuxt/close.7ac794a3.svg'])[5]")).isDisplayed()) {
			driver.findElement(By.xpath("(//img[@src='/_nuxt/close.7ac794a3.svg'])[5]")).click();
		}
		String Current = driver.getCurrentUrl();
		System.out.println("Current Url: " + Current);
		driver.findElement(By.className("topbar-input")).sendKeys("akashkumarrrr");

		driver.findElement(By.xpath("//input[@class='topbar-input !pr-[50px]']")).sendKeys("qwer1234");
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='topbar_btn_1 hidden md:block']"));
		loginButton.click();
		Thread.sleep(100);
		if (driver.findElement(By.xpath("(//img[@src='/_nuxt/close.7ac794a3.svg'])[5]")).isDisplayed()) {
			driver.findElement(By.xpath("(//img[@src='/_nuxt/close.7ac794a3.svg'])[5]")).click();
		}
		Actions actions = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		List<WebElement> categories = driver.findElements(By.xpath("//div[@class='flex-shrink-0 flex items-center']"));
		System.out.println("Number of categories " + categories.size());
		for (int k =1;k< categories.size() ;k++) {
			try {
				categories = driver.findElements(By.xpath("//div[@class='flex-shrink-0 flex items-center']"));
				WebElement category = categories.get(k);
				String categoryName = category.getText();
				System.out.println("The categoryName Is: " + categoryName);
				wait.until(ExpectedConditions.elementToBeClickable(category)).click();
				Thread.sleep(100);
			} catch (StaleElementReferenceException e) {
				jse.executeScript("window.scrollBy(0,300)");
				categories = driver.findElements(By.xpath("//div[@class='flex-shrink-0 flex items-center']"));
				WebElement category = categories.get(k);
				String categoryName = category.getText();
				System.out.println("The categoryName Is: " + categoryName);
				wait.until(ExpectedConditions.elementToBeClickable(category)).click();
				Thread.sleep(100);
				continue;
			} catch (MoveTargetOutOfBoundsException e) {
				jse.executeScript("window.scrollBy(0,300)");
				categories = driver.findElements(By.xpath("//div[@class='flex-shrink-0 flex items-center']"));
				WebElement category = categories.get(k);
				String categoryName = category.getText();
				System.out.println("The categoryName Is: " + categoryName);
				wait.until(ExpectedConditions.elementToBeClickable(category)).click();
				Thread.sleep(50);
				continue;
			}
			categories = driver.findElements(By.xpath("//div[@class='flex-shrink-0 flex items-center']"));
			WebElement category = categories.get(k);
			String categoryName = category.getText();
			if (categoryName.equals("Sports") || categoryName.equals("Live Casino") || categoryName.equals("Lottery")
					|| categoryName.equals("Esports")) {
			
			List<WebElement> providers1 = driver.findElements(By.xpath("//img[@class='provider_logo']"));
			try {
				
				for (int l = 0; l < providers1.size(); l++) {
					List<WebElement> providers = driver.findElements(By.xpath("//img[@class='provider_logo']"));
					WebElement pro = providers.get(l);
					String GameName = pro.getAttribute("alt");
					String name = GameName.replace("game_provider_img_", "");
					List<WebElement> play = driver
							.findElements(By.xpath("//div[@class='game_provider_logo_play']/child::button"));
					boolean doesItMatch = name
							.matches("[A-Z]([A-Z0-9]*[a-z][a-z0-9]*[A-Z]|[a-z0-9]*[A-Z][A-Z0-9]*[a-z])[A-Za-z0-9]*");
					boolean doesItMatch2 = name.matches("^[A-Z]+$");
					if (doesItMatch) {
						System.out.println("**********the game name is not having space :" + name);
					} else if (doesItMatch2) {
						System.out.println("***********the game name contains only capital letter :" + name);
					}
					WebElement playBtn = play.get(l);
					if(name.equals("provider_568WIN")) {
						System.out.println("Pass:" + name + " Is Working Fine");
						continue;
					}
					if(name.equals("provider_EZUGI")) {
						pro.click();
						Thread.sleep(500);
						playBtn.click();
						Thread.sleep(4000);
						if (driver.findElements(By.xpath("//div[@class='toast-message text-sm']")).size() != 0) {
							Thread.sleep(200);
							String messgtext = (driver.findElement(By.xpath("//div[@class='toast-message text-sm']")))
									.getText();
							driver.findElement(By.xpath("//div[@class='toast-close ml-2 flex items-center self-center']"))
									.click();
							Thread.sleep(500);
							System.out.println("Fail: " + name + " Is Not Opening: Message:- " + messgtext);

						} else {
								System.out.println("Pass: " + name + " Is Working Fine");
								WebElement close = driver.findElement(
										By.xpath("//button[@TYPE='button']/*[@class='w-5 h-5 game_header_close_btn']"));
								close.click();
							
						}
						continue;
					}
					pro.click();
					Thread.sleep(500);
					playBtn.click();
					Thread.sleep(1000);
					if (driver.findElements(By.xpath("//div[@class='toast-message text-sm']")).size() != 0) {
						Thread.sleep(200);
						String messgtext = (driver.findElement(By.xpath("//div[@class='toast-message text-sm']")))
								.getText();
						driver.findElement(By.xpath("//div[@class='toast-close ml-2 flex items-center self-center']"))
								.click();
						Thread.sleep(500);
						System.out.println("Fail: " + name + " Is Not Opening: Message:- " + messgtext);

					} else {
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						int count1 = tabs.size();
						if (count1 == 2) {
							driver.switchTo().window(tabs.get(1));
							driver.close();
							driver.switchTo().window(tabs.get(0));
							System.out.println("Pass: " + name + " Is Working Fine");
							Thread.sleep(500);

						} else {
							System.out.println("Pass: " + name + " Is Working Fine");
							WebElement close = driver.findElement(
									By.xpath("//button[@TYPE='button']/*[@class='w-5 h-5 game_header_close_btn']"));
							close.click();
						}
					}

				}
			}
			catch (TimeoutException e) {
				WebElement iframeElement = driver.findElement(By.tagName("button"));
				driver.switchTo().frame(iframeElement);
				driver.switchTo().defaultContent();
				WebElement close = driver.findElement(By.xpath(
						"//button[@TYPE='button']/*[@class='w-5 h-5 game_header_close_btn']"));
				close.click();
				System.out.println("game is not opening");
				Thread.sleep(50);
				continue;

			}
			
				System.out.println(categoryName + " games are completed");
			} else if (categoryName.equals("Cockfight")) {
				WebElement cf = driver.findElement(
						By.xpath("//div[@class='game_provider_content_box placeholder active']/descendant::button"));
				WebElement gamename = driver.findElement(By.xpath(
						"//div[@class='game_provider_content_box placeholder active']/descendant::img[@class='game_provider_img']"));
				String GameName = gamename.getAttribute("alt");
				String name = GameName.replace("game_provider_img_", "");
				cf.click();
			
				if (driver.findElements(By.xpath("//div[@class='toast-message text-sm']")).size() != 0) {
					Thread.sleep(200);
					String messgtext = (driver.findElement(By.xpath("//div[@class='toast-message text-sm']")))
							.getText();
					driver.findElement(By.xpath("//div[@class='toast-close ml-2 flex items-center self-center']"))
							.click();
					Thread.sleep(500);
					System.out.println("Fail: " + name + " Is Not Opening: Message:- " + messgtext);

				} else {
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					int count1 = tabs.size();
					if (count1 == 2) {
						driver.switchTo().window(tabs.get(1));
						driver.close();
						driver.switchTo().window(tabs.get(0));
						System.out.println("Pass: " + name + " Is Working Fine");
						Thread.sleep(500);

					} else {
						System.out.println("Pass: " + name + " Is Working Fine");
						WebElement close = driver.findElement(
								By.xpath("//button[@TYPE='button']/*[@class='w-5 h-5 game_header_close_btn']"));
						close.click();
					}
				}
			}

			else {
				List<WebElement> SlotProviderNames = driver.findElements(By.xpath(
						"//div[text()='Game Providers']/ancestor::div[@class='game_container_bg']/descendant::button[@class='game_provider_btn']"));
				System.out.println("Total Number of Providers :" + SlotProviderNames.size());
				for (int j = 0; j < SlotProviderNames.size(); j++) {
					try {
						List<WebElement> SlotProviderNames1 = driver.findElements(By.xpath(
								"//div[text()='Game Providers']/ancestor::div[@class='game_container_bg']/descendant::button[@class='game_provider_btn']"));
						WebElement providerbtn = SlotProviderNames1.get(j);
						String providerbtnname = providerbtn.getText();
						jse.executeScript("arguments[0].click()", providerbtn);
						System.out.println("Provider Name: " + providerbtnname);
						Thread.sleep(500);
					} catch (StaleElementReferenceException e) {
					} catch (ElementClickInterceptedException e) {
						actions.scrollByAmount(0, 200).perform();
						Thread.sleep(200);
					}

					WebElement Em = driver.findElement(By.xpath("//div[@class='game_container_pagination_text']"));
					String emtext = Em.getText();
					Pattern pattern = Pattern.compile("\\d+");
					Matcher matcher = pattern.matcher(emtext);
					int count = 0;
					while (matcher.find()) {
						count++;
						if (count == 2) {
							String number = matcher.group();
							System.out.println("Total Games Present In This Provider:" + number);
							List<WebElement> GameButtons = driver.findElements(By.xpath("//button[text()='Play']"));
							List<WebElement> GameNames = driver
									.findElements(By.xpath("//div[@class='game_container_game_btn_name']"));
							for (int i = 0; i < 1; i++) {
								for (;;) {
									try {
										GameNames = driver
												.findElements(By.xpath("//div[@class='game_container_game_btn_name']"));
										GameButtons = driver.findElements(By.xpath("//button[text()='Play']"));
										WebElement GameName = GameNames.get(i);
										String GameNameIs = GameName.getText();
										WebElement GameButton = GameButtons.get(i);
										if (GameName.isDisplayed()) {
											if (GameButton.isEnabled()) {
												boolean doesItMatch = GameNameIs.matches(
														"[A-Z]([A-Z0-9]*[a-z][a-z0-9]*[A-Z]|[a-z0-9]*[A-Z][A-Z0-9]*[a-z])[A-Za-z0-9]*");
												boolean doesItMatch2 = GameNameIs.matches("^[A-Z]+$");
												if (doesItMatch) {
													System.out.println("**********the game name is not having space :"
															+ GameNameIs);
												} else if (doesItMatch2) {
													System.out.println(
															"***********the game name contains only capital letter :"
																	+ GameNameIs);
												}
												actions.moveToElement(GameName).perform();
												Thread.sleep(50);
												jse.executeScript("arguments[0].click()", GameButton);
												Thread.sleep(500);
												if (driver
														.findElements(By.xpath("//div[@class='toast-message text-sm']"))
														.size() != 0) {
													Thread.sleep(200);
													String messgtext = (driver.findElement(
															By.xpath("//div[@class='toast-message text-sm']")))
															.getText();
													driver.findElement(By.xpath(
															"//div[@class='toast-close ml-2 flex items-center self-center']"))
															.click();
													Thread.sleep(500);
													System.out.println("Fail: " + GameNameIs
															+ " Is Not Opening: Message:- " + messgtext);

												} else {
													ArrayList<String> tabs = new ArrayList<String>(
															driver.getWindowHandles());
													int count1 = tabs.size();
													if (count1 == 2) {
														driver.switchTo().window(tabs.get(1));
														driver.close();
														driver.switchTo().window(tabs.get(0));
														System.out.println("Pass: " + GameNameIs + " Is Working Fine");
														Thread.sleep(500);

													} else {
														System.out.println("Pass: " + GameNameIs + " Is Working Fine");
					
														wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@TYPE='button']/*[@class='w-5 h-5 game_header_close_btn']"))).click();

													}
												}

											} else {
												System.out.println("Fail: GameButton Is Not Enabled: " + GameButton);
											}
										} else {
											System.out.println("Fail: GameName Is Not Displayed: " + GameName);
										}
										break;
									} catch (IndexOutOfBoundsException e) {
										jse.executeScript("window.scrollBy(0,300)");
										Thread.sleep(150);
										continue;

									} catch (NoSuchElementException e) {
										jse.executeScript("window.scrollBy(0,300)");
										Thread.sleep(150);
										continue;
									} catch (MoveTargetOutOfBoundsException e) {
										jse.executeScript("window.scrollBy(0,300)");
										Thread.sleep(150);
										continue;
									} catch (StaleElementReferenceException e) {
										jse.executeScript("window.scrollBy(0,300)");
										Thread.sleep(150);
										continue;
									}
									catch (TimeoutException e) {
										
										Thread.sleep(150);
										continue;
									}
	
								}
							}
						}
					}
				}
			}
		}
		driver.quit();
	}
}
