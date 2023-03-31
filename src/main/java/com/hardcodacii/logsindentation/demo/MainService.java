package com.hardcodacii.logsindentation.demo;

import com.hardcodacii.logsindentation.service.DisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

@Service
@RequiredArgsConstructor
public class MainService {
	private static final int no = 2;
	private final DisplayService displayService;

	public static void printStackTrace() {
		var thread = Thread.currentThread();
		var stackLength = thread.getStackTrace().length;
		var stackTrace = thread.getStackTrace();

		for (var i = 0; i < stackLength; i++) {
			System.out.println("ste[" + i + "]: " + stackTrace[i]);
		}
		System.out.println();
	}

	public void start() {
		System.out.println();
		displayService.infoLn("enter method Main.start");
		displayService.infoLn("enter method Main.start");

		A();
		displayService.emptyLine();
		B();
		displayService.emptyLine();
		C();
		displayService.emptyLine();
		D();
		displayService.emptyLine();

		displayService.infoLn("exit method Main.start");
		displayService.infoLn("exit method Main.start");
	}

	public void A() {
		displayService.infoLn("method A");
		B();
	}

	public void B() {
		displayService.infoLn("method B");
	}

	public void C() {
		displayService.infoLn("method C");
		for (var i = 1; i <= no; i++) {
			A();
		}
		B();


		displayService.infoLn("method C");
		for (var i = 1; i <= no; i++) {
			B();
		}
		A();
	}

	public void D() {
		displayService.infoLn("method D");
		A();
		displayService.emptyLine();
		C();
		displayService.emptyLine();
		B();
		displayService.emptyLine();
	}
}
