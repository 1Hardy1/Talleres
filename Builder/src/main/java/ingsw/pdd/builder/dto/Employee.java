package ingsw.pdd.builder.dto;

 import java.util.ArrayList;
 import java.util.List;
 import ingsw.pdd.builder.IBuilder;
 import ingsw.pdd.builder.dto.*;

 public class Employee {
		
		private String 			name ;
		private String 			gender;
		private int    			age;
		private Address 		address;
		private List<Phone>		phones;
		private List<Contact>	contacs;

		private Employee(String name, String gender, int age, Address address, List<Phone> phones,
			List<Contact> contacs) {
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.address = address;
			this.phones = phones;
			this.contacs = contacs;
		}

		
		public Employee(String name,int age, String gender) {
			
			this.name = name;
			this.gender = gender;
			this.age = age;
		}
		
		public Employee() {
			
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Phone> getPhones() {
			return phones;
		}

		public void setPhones(List<Phone> phones) {
			this.phones = phones;
		}

		public List<Contact> getContacs() {
			return contacs;
		}

		public void setContacs(List<Contact> contacs) {
			this.contacs = contacs;
		}

		public String toString() {
			return "Employee{"+ "name= "+name+" age= "+ age +" gender= "+gender+"\naddress= "+
		address+ "phone=" +phones+" contacs= "+contacs+ '}';
					
		}
		
		
		
		
		public static class EmployeeBuilder implements IBuilder<Employee>{
			
			private String name;
			private int age;
			
			private String gender; 
			private Address	address;
		
			private final List<Phone> phones = new ArrayList<>(); 
			private final List<Contact> contacs = new ArrayList<>();
			
			public EmployeeBuilder() {
				
				
			}
			
			

		
			
			
			
			
			public EmployeeBuilder setName(String name) {
				this.name=name;
				return this;
			}

			public EmployeeBuilder setAge(int age) {
				this.age=age;
				return this;
			}

			public EmployeeBuilder setGender(String gender) {
				this.gender=gender;
				return this;
			}


			public EmployeeBuilder setAddress(String  dir,  String ciudad,String pais, String cp) 
			{ address= new Address(dir, ciudad, pais, cp);
					
					return this;  }
			
			
			
					
					public EmployeeBuilder addPhones(String phoneNumber, String ext,
			
					String phoneType) {  phones.add(new Phone(phoneNumber, ext, phoneType));
					
					return this; }
				
				 public EmployeeBuilder addContacs(String name, String phoneNumber,
				
					String ext, String phoneType,String address, String city, String country, String cp) {
				contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)
				 ,new Address(address, city, country, cp)));
					
					return this;}
				 
				 public EmployeeBuilder addContacs(String name, String phoneNumber,
						
						 String ext, String phoneType) { contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)));

						 return this;  }

				


				@Override
				public Employee build() {
			
					return new Employee(name, gender, age, address, phones, contacs);
				}
				 
				 
				
				 }
			
			
		
	}