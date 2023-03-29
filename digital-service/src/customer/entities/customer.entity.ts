import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Customer {
  @PrimaryGeneratedColumn()
  uuid: number;

  @Column()
  id: number;

  @Column()
  name: string;

  @Column()
  gender: string;

  @Column()
  customer_dni: string;

  @Column()
  customer_channel: string;
}
