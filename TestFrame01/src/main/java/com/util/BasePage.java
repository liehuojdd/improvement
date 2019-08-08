package com.util;

import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 *  Selenium Base Test
 *  
 * @author mark zhang
 * @version 1.0 
 * @since 1.0 
 */  
public class BasePage {
	public WebDriver driver;

	private String fileUpload = "D:\\hw.jpg";
	

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// Base Actions
	/**
	 * Send keys to element.
	 */
	protected void Type(WebElement element, String text) {
		try {
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage() + ".");
		}

	}

	/**
	 * Clean text box.
	 */
	protected void Clean(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.clear();
				Logger.Output(Logger.LogTypeName.INFO, "Element " + element.toString() + " was cleaned.");
			}
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage() + ".");
		}

	}

	/**
	 * Click element
	 */
	protected void Click(WebElement element) {
		try {
			// element.isEnabled() seems not work for page loaded
			if (element.isEnabled()) {
				element.click();
				// Logger.Output(Logger.LogTypeName.INFO, "Element: "+element.toString()+" was clicked.");
			}
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}

	}

	/**
	 * Click element adding WebDriverWait, using located to new page.
	 * @param locator
	 */
	protected void Click(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
	}

	/**
	 * An optional function using Timer.
	 */
	private void Click_Optional(WebElement element, String pathname, int sleepTime) {
		try {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					driver.quit();
					System.out.println("No responsive after click 5 minutes");
				}
			}, 120000);
			if (element != null) {
				element.click();
				timer.cancel();
				if (sleepTime > 0) {
					Thread.sleep(sleepTime);
				}
			}

		} catch (Exception e) {
			System.out.println("ClickOptional exception.");
		}

	}

	/**
	 * Return text in element.
	 */
	protected String GetText(WebElement element) {
		try {
			return element.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * Get element text by WebDriverWait, using located to new page.
	 * @param locator
	 */
	protected String GetText(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element.getText();
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
		return "";
		
	}
	
	/**
	 * Get attribute value
	 */
	protected String GetAttributeValue(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}
	/**
	 * An optional function using WebDriverWait.
	 */
	private String GetText_Optional(By locator) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		return myDynamicElement.getText();
		// myDynamicElement.wait();
	}

	
	/**
	 * Keep selectValue as default. if no value, leave it blank.
	 */
	protected void Select(WebElement element, String selectValue,int selectIndex) {
		try {
			Select select = new Select(element);
			if(selectValue.isEmpty()) {
				select.selectByIndex(selectIndex);
			}
			select.selectByValue(selectValue);
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
	}

	// Others Actons
	/**
	 * @param sleepSecond, sleep in second.
	 */
	protected void Sleep(int sleepSecond) {
		try {
			Thread.sleep(sleepSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Verify the element.
	 * 
	 * @param element
	 * @throws Log error
	 */
	protected Boolean VerifyElementIsPresent(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
				//Logger.Output(Logger.LogTypeName.INFO, "This Element " + element.toString().trim() + " is present.");
			}
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage() + ".");
		}
		return false;
	}

	protected String GetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
		return "";
	}

	protected String GetPageUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
		return "";
	}

	protected void SwitchToMain() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		try {
			driver.switchTo().window(it.next());
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, "Open in new window" + e.getMessage());

		}
	}
	
	private void SwitchWindow_Optional() {
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Logger.Output(Logger.LogTypeName.INFO, "current window " + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			try {
				driver.close();
				WebDriver window = driver.switchTo().window(it.next());
				//Logger.Output(Logger.LogTypeName.INFO, "new page title is " + window.getTitle());
			} catch (Exception e) {
				Logger.Output(Logger.LogTypeName.ERROR, "Open in new window" + e.getMessage());

			}
			// driver.close();
		}
		// driver.switchTo().window(currentWindow);
	}

	/**
	 * To do list.
	 */
	protected void SwitchFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**
	 * 
	 * @param mouseEvent:
	 * 1-DoubleClick
	 * 2-MoveToElement
	 * 3-DragAndDrop, from element to targetElement.
	 * 4-DragAndDropBy, from element to targetRange.
	 * @param element
	 * @param targetElement
	 * @param targetRange: Move to location "x,y"
	 */
	protected void MouseEvent(int mouseEvent,WebElement element,WebElement targetElement,String targetRange) {
		Actions action=new Actions(driver);
		switch(mouseEvent) {
			case 1:
				action.doubleClick(element);
				break;
			case 2:
				action.moveToElement(element);
				break;
			case 3:
				action.dragAndDrop(element,targetElement);
				break;
			case 4:
				int x=Integer.parseInt(targetRange.substring(0,targetRange.indexOf(",")));
				int y=Integer.parseInt(targetRange.substring(targetRange.indexOf(",")+1));
				action.dragAndDropBy(element,x,y);
				break;
			default:
				break;
		}
		action.perform();
		
	}
	
	protected void ExecuteJS(String script) {
		try {
			((JavascriptExecutor) driver).executeScript(script);
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
	}

	/**
	 * @param uploadElement,filed the input upload element Such as:
	 *  xpath="//form[@id='search-img-upload']/input"
	 */
	protected void FileUpload(WebElement uploadElement) {
		try {
			uploadElement.sendKeys(fileUpload);
		} catch (Exception e) {
			Logger.Output(Logger.LogTypeName.ERROR, e.getMessage());
		}
	}
	
	/**
	 * @param element
	 * @param sendKeys:
	 * Enter,
	 * Backspace,
	 * Tab,
	 * Space,
	 * Others under namespace selenium.Keys 
	 */
	protected void SendKeys(WebElement element,String sendKeys) {
		Actions action=new Actions(driver);
		if (sendKeys.equals("Enter")){
			action.sendKeys(element,Keys.ENTER);
		}else if (sendKeys.equals("Backspace")){
			action.sendKeys(element,Keys.BACK_SPACE);
		}else if (sendKeys.equals("Tab")){
			action.sendKeys(element,Keys.TAB);
		}else if (sendKeys.equals("Space")){
			action.sendKeys(element,Keys.SPACE);
		}else{
			action.sendKeys(element,sendKeys);
		}
		action.build().perform();
	}
	
	/**
	 * For WebDriver, scroll included in FindElement.
	 * Most of conditions no need scroll function.
	 *  <pre class="code">
	 *  this.Type(confrimPsw, "text");
	 *  this.Click(submitBtn);
	 *  </pre>
	 */
	protected void ScrollToButtom() {
		String setscroll = "window.scrollTo(0, document.body.scrollHeight)";
		ExecuteJS(setscroll);
	}
	
	/**
	 * Is accept the alert, if false, dismiss.
	 */
	protected void AlertHandle(Boolean accept) {
		if(accept) {
			driver.switchTo().alert().accept();
		}else {
			driver.switchTo().alert().dismiss();
		}
		
	}
	
	
}
