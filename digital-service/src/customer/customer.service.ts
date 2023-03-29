import { Injectable, NotFoundException } from '@nestjs/common';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { Customer } from './entities/customer.entity';
import { CreateCustomerDto } from './dto/create-customer.dto';




@Injectable()
export class CustomerService {

  constructor(@InjectRepository(Customer) private repo: Repository<Customer>) { }

  create(createCustomerDto: CreateCustomerDto) {
    const newCustomer = this.repo.create(createCustomerDto);
    return this.repo.save(newCustomer);
  }

  findAll() {
    return this.repo.findAndCount();
  }

  async findOne(id: number) {
   const Customer = await this.repo.findOne({ where: { id } });
    if(!Customer) {
      throw new NotFoundException("Customer not found")
    }
    return Customer;
  }

 
}
