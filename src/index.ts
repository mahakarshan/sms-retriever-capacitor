import { WebPlugin } from '@capacitor/core';
import {  registerPlugin } from '@capacitor/core';

/**
 * Represents the options for reading SMS.
 */
export interface ReadSMSOptions {
  /**
   * The search string used to find the OTP in the SMS.
   */
  searchString: string;
}

/**
 * Represents the result of reading SMS.
 */
export interface ReadSMSResult {
  /**
   * The OTP extracted from the SMS.
   */
  otp: string;
}

/**
 * Defines the interface for the SMSReaderPlugin.
 */
export interface SMSReaderPlugin {
  /**
   * Reads the OTP from SMS messages based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves with an object containing the OTP.
   */
  readSMS(options: ReadSMSOptions): Promise<ReadSMSResult>;
}

/**
 * Web implementation of the SMSReaderPlugin.
 */
export class SmsReaderWeb extends WebPlugin implements SMSReaderPlugin {
  /**
   * Reads the OTP from SMS messages based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves with an object containing the OTP.
   */
  async readSMS(options: ReadSMSOptions): Promise<ReadSMSResult> {
    console.log('Web implementation not available');
    console.log(options)
    return { otp: '' };
  }
}

const SmsReader = registerPlugin<SMSReaderPlugin>('SmsReader', {
  web: () => import('./web').then(m => new m.SmsReaderWeb()),
});

export * from './definitions';
export { SmsReader };
