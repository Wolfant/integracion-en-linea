import { IsString, IsNumber } from "class-validator";

export class CreateCustomerDto {
    @IsNumber()
    id: number

    @IsString()
    name: string

    @IsString()
    gender: string

    @IsString()
    customer_dni: string

    @IsString()
    customer_channel: string
}
