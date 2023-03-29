import { Module } from '@nestjs/common';

import { CustomerService } from './customer.service';
import { CustomerController } from './customer.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Customer } from './entities/customer.entity';

@Module({
  imports: [TypeOrmModule.forRoot({
    type: 'sqlite',
    database: 'db.sqlite',
    entities: [Customer],
    synchronize: true,
  }), TypeOrmModule.forFeature([Customer]) ],
  controllers: [CustomerController],
  providers: [CustomerService]
})
export class CustomerModule { }
