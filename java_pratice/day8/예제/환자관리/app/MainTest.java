package lab.ssafy.corona.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab.ssafy.com.medical.CDC;
import lab.ssafy.com.medical.Hospital;
import lab.ssafy.com.medical.NotCoronaException;
import lab.ssafy.corona.person.Patient;

public class MainTest {

	public static void main(String[] args) {
		// 병원 생성
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);

		// 환자 생성
		Patient p1 = new Patient("환자1", 42, "010-1111-1111", "호흡곤란", "001", true);
		Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", true);

		// 병원 Collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);

		// 환자 Collection
		Set<Patient> patientList = new HashSet<Patient>();
		patientList.add(p1);
		patientList.add(p2);

		CDC cdc = new CDC("질병관리청", 200, hospitalList, patientList);
		cdc.about();
		

		// 병원에 cdc 연결
		univHospital.setCdc(cdc);        //이거
		localHospital.setCdc(cdc);		 // 이거 연결 안되면 밑에서 print하면 null 나옴.
//		//새로운 환자 등록
//		Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
//		univHospital.addPatient(p3);
//		univHospital.addPatient(p3);  //중복되도 하나만 처리함.
//		
		// p3 과 동일정보의 환자 p4 등록
//		Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false); //hashcode오버라이딩해서 처리됨.
//		univHospital.addPatient(p4);
//		// p3 과 동일정보의 환자로 p3 삭제 시도
//		Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
//		univHospital.removePatient(p4);
		
		
		// 예외 체크 check
				Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
				try {
					univHospital.addPatient(p3);
				}catch(NotCoronaException e) {
					System.out.println("등록하려는 환자는 Corona 환자가 아닙니다.");
				}
		cdc.printPatientList();
		
		
		////////////////////////////////////////////////////////
		// 환자 리스트 csv 파일 출력
				String filePath = "c:"+File.separator+"SSAFY";
				String fileName = "CoronaPatientList.csv";
		try (				
				BufferedWriter writer = 
				new BufferedWriter(
					new OutputStreamWriter(
						new FileOutputStream(filePath+File.separator+fileName), "MS949"));
			){
				for( Patient p : patientList ) {
					writer.write(p.getName() + "^" + p.getAge() + "^" + p.getPhone());
					writer.newLine();
				}
				writer.flush();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
}


