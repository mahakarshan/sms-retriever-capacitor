import { WebPlugin } from '@capacitor/core';
import { SmsReaderPlugin, ReadSMSOptions, ReadSMSResult } from './definitions';

/**
 * Web implementation of the SmsReaderPlugin.
 */
export class SmsReaderWeb extends WebPlugin implements SmsReaderPlugin {
  /**
   * Reads the OTP from SMS messages based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves with an object containing the OTP.
   */
  async readSMS(options: ReadSMSOptions): Promise<ReadSMSResult> {
    console.log('Web implementation not available');
    console.log(options);
    return { otp: '' };
  }

  /**
   * Starts watching for SMS messages to read the OTP based on the provided search string.
   * @param options - An object containing the search string.
   * @returns A promise that resolves when the watching starts.
   */
  async startWatching(options: ReadSMSOptions): Promise<ReadSMSResult> {
    console.log('Web implementation not available');
    console.log('Start watching with options:', options);
    return { otp: '' };

  }

  /**
   * Stops watching for SMS messages.
   * @returns A promise that resolves when the watching stops.
   */
  async stopWatching(): Promise<void> {
    console.log('Web implementation not available');
    console.log('Stop watching');
  }
}

const SmsReader = new SmsReaderWeb();
export { SmsReader };
