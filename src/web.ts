import { WebPlugin } from '@capacitor/core';

import type { smsPlugin } from './definitions';

export class smsWeb extends WebPlugin implements smsPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
