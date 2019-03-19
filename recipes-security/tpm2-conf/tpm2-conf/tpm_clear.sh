#!/bin/sh

#echo "Clearing TPM and setting primary storage key to 0x81000001"
tssclearcontrol -hi p -state 0
tssclear -hi p
tssclearcontrol -hi p -state 1
TPM_DEVICE=/dev/tpm0 tsscreateprimary -hi o -rsa
TPM_DEVICE=/dev/tpm0 tssevictcontrol -hi o -ho 80000000 -hp 0x81000001
TPM_DEVICE=/dev/tpm0 tssflushcontext -ha 80000000
