import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Arrays;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class RandomNumber {
	
	protected Shell shell;
	private Text text;
	private int[] numbers = new int[5];
	private int sum ;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RandomNumber window = new RandomNumber();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(92, 39, 226, 50);
		
		//ปุ่มสุ่มตัวเลข
		Button btnRamdom = new Button(shell, SWT.NONE);
		btnRamdom.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Random random = new Random();
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = random.nextInt(100);
				}
				text.setText(Arrays.toString(numbers));
				System.out.println(numbers);
			}
		});
		btnRamdom.setBounds(71, 134, 75, 25);
		btnRamdom.setText("Ramdom");
		
		
		//ปุ่มรียงข้อมูล
		Button btnSort = new Button(shell, SWT.NONE);
		btnSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Arrays.sort(numbers);
				text.setText(Arrays.toString(numbers));
			}
		});
		btnSort.setText("Sort");
		btnSort.setBounds(168, 134, 75, 25);
		
		//ปุ่มรวมค่าใน array
		Button btnSum = new Button(shell, SWT.NONE);
		btnSum.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				  sum = sumRecursive(numbers, 0, numbers.length - 1);
				  text.setText("ค่าผลรวมใน Array : " + sum);
				}

				private int sumRecursive(int[] arr, int start, int end) {
				  if (start > end) {
				    return 0;
				  }
				  return arr[start] + sumRecursive(arr, start + 1, end);
				}
		});
		btnSum.setBounds(269, 134, 75, 25);
		btnSum.setText("Sum");
		
		// รี
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(" ");
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = 0;
				}
			}
		});
		btnNewButton.setBounds(71, 103, 75, 25);
		btnNewButton.setText("รีรีรี");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(188, 18, 55, 15);
		label.setText("สุ่มตัวเลข");
		
		//ปุ่มแปลงเลขฐาน 2
		Button btnBinary = new Button(shell, SWT.NONE);
		btnBinary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String binary = Integer.toBinaryString(sum);
				text.setText("เลขฐาน 2 ของ " + sum +" คือ "+ binary);
			}
			
		});
		btnBinary.setBounds(71, 170, 75, 25);
		btnBinary.setText("Binary");
		
		//ปุ่มแปลงเลขฐาน 16
		Button btnHex = new Button(shell, SWT.NONE);
		btnHex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String hex = Integer.toString(sum,16);
				text.setText("เลขฐาน 16 ของ " + sum +" คือ "+hex);
			}
		});
		btnHex.setBounds(269, 170, 75, 25);
		btnHex.setText("Hex");
		
		//ปุ่มแปลงเลขฐาน 8
		Button btnOctal = new Button(shell, SWT.NONE);
		btnOctal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String octal = Integer.toOctalString(sum);
				text.setText("เลขฐาน 8 ของ " + sum +" คือ "+ octal);
			}
		});
		btnOctal.setBounds(168, 170, 75, 25);
		btnOctal.setText("Octal");
		
		
		//ปุ่มกลับหน้าหลัก
		Button btnHome = new Button(shell, SWT.NONE);
		btnHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        shell.dispose();
		        // Open Practice form
		        Practice practice = new Practice();
		        practice.open();
			}
		});
		btnHome.setBounds(269, 103, 75, 25);
		btnHome.setText("Home");
		

		

	}
}